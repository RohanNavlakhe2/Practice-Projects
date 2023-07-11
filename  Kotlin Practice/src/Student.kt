open class Student {

    protected fun f1(){
        println("f1")
    }

    fun f2(){
        f1()
        val s = Student()
        s.f1()
    }
}

fun main(){
    val s = StudentA()
}

class StudentA:Student(){

    fun f3(){
        val s = StudentA()
        s.f1()
        val s2 = Student()

    }
}

val s = Student()

