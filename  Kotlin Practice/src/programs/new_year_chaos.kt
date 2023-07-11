package programs

import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

/*
 * Complete the 'minimumBribes' function below.
 *
 * The function accepts INTEGER_ARRAY q as parameter.
 */

private lateinit var result:ArrayList<String>

fun minimumBribes(q: Array<Int>): Unit {

    var totalNoOfBribes = 0
    var index = 0
    var lastCheckedValue = -1

    while(index < q.size){

        if(q[index] == index + 1 || q[index] < lastCheckedValue){
            index+=1
            continue
        }
        else{
            val currentNoOfBribes = (q[index] - 1) - index

            if(currentNoOfBribes > 2){
                result.add("Too chaotic")
                return
            }

            totalNoOfBribes += currentNoOfBribes
            lastCheckedValue = q[index]
            //index += currentNoOfBribes + 1
            index += 1

        }
    }

    result.add(totalNoOfBribes.toString())
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    result = ArrayList()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()

        val q = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

        minimumBribes(q)
    }

     print(result.joinToString("\n"))
}
