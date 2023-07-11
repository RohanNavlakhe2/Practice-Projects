package programs

fun main(){
   /* val num = 5
    num.fact()

    val s:String = "r"
    val s1:String = "R"

   val a = s === s1*/

   /* val arr = Array(10) {
        return@Array 0
    }*/

    

}


fun Int.fact(){

    var result = 1

    for(i in this downTo 1){
        println(i)
        result *= i
    }

    println(result)

}