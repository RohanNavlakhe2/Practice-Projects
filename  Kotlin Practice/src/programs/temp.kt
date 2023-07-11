package programs

fun main(){
    val hashMap = HashMap<Int?,String>()
    hashMap[null] = ""
    hashMap[null] = "5"
    println(hashMap)
}

interface A {
    fun a(){

    }
}

interface B {
    fun a(){

    }
}

class ABA:A,B{
    override fun a() {
         super<A>.a()
    }

}