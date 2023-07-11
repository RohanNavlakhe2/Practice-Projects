package com.example.googlecalendarapi

import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.googlecalendarapi.Constants.AUTHORIZATION_ENDPOINT
import com.example.googlecalendarapi.Constants.CALENDAR_EVENTS_SCOPE
import com.example.googlecalendarapi.Constants.REDIRECT_URI
import com.example.googlecalendarapi.Constants.TOKEN_ENDPOINT
import kotlinx.coroutines.*
import net.openid.appauth.*
import net.openid.appauth.browser.BrowserAllowList
import net.openid.appauth.browser.VersionedBrowserMatcher
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONException
import org.json.JSONObject
import java.security.MessageDigest
import java.security.SecureRandom

class MainActivity : AppCompatActivity() {

    private var authState: AuthState = AuthState()
    private lateinit var authorizationService : AuthorizationService
    lateinit var authServiceConfig : AuthorizationServiceConfiguration
    private var codeChallenge = ""
    private var codeVerifier = ""

    private lateinit var activityResultLauncher:ActivityResultLauncher<Intent>
    private lateinit var button:Button
    private lateinit var responseTxt:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btn)
        responseTxt = findViewById(R.id.responseTxt)

        //restoreState()

        /*if(TextUtils.isEmpty(authState.idToken)){
            initAuthServiceConfig()
            initAuthService()
            generateCodeChallenge()
            registerForResult()
        }else{
            button.visibility = View.GONE
            Log.d("Outcome","OnCreate : $authState")
        }*/


        initAuthServiceConfig()
        initAuthService()
        generateCodeChallenge()
        registerForResult()

        button.setOnClickListener {
            initAuthRequest()
        }
    }

    private fun initAuthServiceConfig() {
        authServiceConfig = AuthorizationServiceConfiguration(
            Uri.parse(AUTHORIZATION_ENDPOINT),
            Uri.parse(TOKEN_ENDPOINT))
    }

    private fun initAuthService() {
        val appAuthConfiguration = AppAuthConfiguration.Builder()
            .setBrowserMatcher(
                BrowserAllowList(
                    VersionedBrowserMatcher.CHROME_CUSTOM_TAB,
                    VersionedBrowserMatcher.SAMSUNG_CUSTOM_TAB
                )
            ).build()

        authorizationService = AuthorizationService(
            application,
            appAuthConfiguration)
    }

    private fun initAuthRequest(){
        val builder = AuthorizationRequest.Builder(
            authServiceConfig,
            Constants.CLIENT_ID,
            ResponseTypeValues.CODE,
            Uri.parse(REDIRECT_URI))
            .setCodeVerifier(codeVerifier,
                codeChallenge,
                Constants.CODE_VERIFIER_CHALLENGE_METHOD)

        builder.setScopes(CALENDAR_EVENTS_SCOPE)

        val request = builder.build()

        val authIntent = authorizationService.getAuthorizationRequestIntent(request)
        activityResultLauncher.launch(authIntent)
    }

    private fun registerForResult(){
       activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            kotlin.run {
                if(result.resultCode == RESULT_OK){
                   Log.d("Outcome",result.data.toString())
                    handleResponse(result.data!!)
                }
            }
        }
    }

    private fun handleResponse(intent:Intent){
        val authorizationResponse : AuthorizationResponse? = AuthorizationResponse.fromIntent(intent)
        val error = AuthorizationException.fromIntent(intent)

        authState = AuthState(authorizationResponse, error)
        createTokenRequest(authorizationResponse!!)
    }

    private fun createTokenRequest(authorizationResponse:AuthorizationResponse){
        val tokenExchangeRequest = authorizationResponse.createTokenExchangeRequest()

        authorizationService.performTokenRequest(tokenExchangeRequest) { response, exception ->
            if (exception != null) {
                authState = AuthState()
            } else {
                if (response != null) {
                    authState.update(response, exception)
                    Log.d("Outcome","Access Token : ${response.accessToken}")
                    makeApiCall()
                    //jwt = JWT(response.idToken!!)
                }
            }
            //persistState()
        }
    }

    private fun generateCodeChallenge(){
        val secureRandom = SecureRandom()
        val bytes = ByteArray(64)
        secureRandom.nextBytes(bytes)

        val encoding = Base64.URL_SAFE or Base64.NO_PADDING or Base64.NO_WRAP
        codeVerifier = Base64.encodeToString(bytes, encoding)

        val digest = MessageDigest.getInstance(Constants.MESSAGE_DIGEST_ALGORITHM)
        val hash = digest.digest(codeVerifier.toByteArray())
        codeChallenge = Base64.encodeToString(hash, encoding)
    }

    private fun persistState() {
        application.getSharedPreferences(Constants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .edit()
            .putString(Constants.AUTH_STATE, authState.jsonSerializeString())
            .commit()
    }

    private fun restoreState() {
        val jsonString = application
            .getSharedPreferences(Constants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
            .getString(Constants.AUTH_STATE, null)

        if( jsonString != null && !TextUtils.isEmpty(jsonString) ) {
            try {
                authState = AuthState.jsonDeserialize(jsonString)

                /*if( !TextUtils.isEmpty(authState.idToken) ) {
                    jwt = JWT(authState.idToken!!)
                }*/

            } catch(jsonException: JSONException) { }
        }
    }

    fun makeApiCall() {
        authState.performActionWithFreshTokens(authorizationService
        ) { accessToken, idToken, ex ->
            GlobalScope.launch {
                async(Dispatchers.IO) {
                    val client = OkHttpClient()
                    val request = Request.Builder()
                        .url(Constants.CALENDAR_API)
                        .addHeader("Authorization", "Bearer " + authState.accessToken)
                        .build()

                    try {
                        val response = client.newCall(request).execute()
                        val jsonBody = response.body?.string() ?: ""
                        Log.d("Outcome","Response : ${JSONObject(jsonBody)}")

                        withContext(Dispatchers.Main){
                            responseTxt.text = jsonBody
                        }

                    } catch (e: Exception) {
                    }
                }
            }
        }
    }
}