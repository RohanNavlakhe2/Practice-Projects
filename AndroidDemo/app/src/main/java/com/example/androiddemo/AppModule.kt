package com.example.androiddemo

import com.example.androiddemo.network.NetworkInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient() : OkHttpClient {
        return OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL:String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://www.omdbapi.com?apikey=577eb312")
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun getMovieApi(retrofit: Retrofit) : NetworkInterface =
        retrofit.create(NetworkInterface::class.java)

    @Singleton
    @Provides
    fun getRepository(api:NetworkInterface) : MainRepository{
        return MainRepository(api)
    }
}