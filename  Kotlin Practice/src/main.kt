

fun main() {

    val p = Person()
    p.personName = "rohan"
    println(p.personName)
    p.personName = "rohan nav"
    println(p.personName)

    val p2 = Product("ABC",10)
    val p3 = Product("ABC",20)
    println("p2 equals to p3 : ${p2 == p3}")
    println("p2 is p3 : ${p2 === p3}")


    for (i in 1 until 10){
        println(i)
    }

    val bmw = Bmw("bmw")
    bmw.f1()

    var s = "Rohan    Nav"
}

private class Person(){

    var personName = ""
    get() = field.trim().toUpperCase()
    set(value) {
        field = "_${value}_"
    }
}

open class Car(var name: String){

    var model:String = ""
    val d:Int = 0

    fun f1(){
        val a:String? = null
        var b = a ?: "A"



    }


}

class Bmw(name: String): Car(name) {

}





