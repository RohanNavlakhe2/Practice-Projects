package com.example.designpatterns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val singletonJava = SingletonJava.getInstance()
        val singletonJava2 = SingletonJava2.getInstance()
        val singletonJava3 = SingletonJava3.INSTANCE

        singletonJava.doSomething()
        singletonJava2.doSomething()
        singletonJava3.doSomething()

        //Normal class
        val success:Result = Success("success")
        val error:Result = Error(10)

        val result = when(success){
            is Success -> success.msg
            is Error -> success.e
            else -> {}
        }

        print(result)


        //Sealed class
        val success2:Result2 = Success2("success")
        val error2:Result2 = Error2(10)

        val result2 = when(success2){
            is Error2 -> success2.e
            is Success2 -> success2.msg
        }

        print(result2)

    }
}


//Normal Class
open class Result {

}

class Success(val msg:String) : Result()
class Error(val e:Int) : Result()



//Sealed Class
sealed class Result2 {

}

class Success2(val msg:String) : Result2()
class Error2(val e:Int) : Result2()