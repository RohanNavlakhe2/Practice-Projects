package programs

fun jumpingOnClouds(c: Array<Int>): Int {

    var jumps = 0
    var currentPosition = 0

     while(currentPosition<c.size-1){
         if(currentPosition + 2 < c.size && c[currentPosition + 2] != 1){
             jumps+=1
             currentPosition+=2
         }else if(currentPosition + 1 < c.size && c[currentPosition + 1] != 1){
             jumps+=1
             currentPosition+=1
         }
     }
    return jumps
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val c = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = jumpingOnClouds(c)

    println(result)
}




