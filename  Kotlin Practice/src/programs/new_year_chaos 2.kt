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

fun minimumBribes2(q: Array<Int>): Unit {

    var totalNoOfBribes = 0
    var numbersWhomBribeGiven = ArrayList<Int>()

    q.forEachIndexed { currentIndexOfValue, value ->
        val actualIndexOfValue = value - 1
        val distance = actualIndexOfValue - currentIndexOfValue

        if(distance > 0){
            if(distance > 2){
                result.add("Too chaotic")
                return
            }
            totalNoOfBribes += distance
        }
        else
            numbersWhomBribeGiven.add(value)
    }

    var maxValue = Int.MIN_VALUE


    for(i in numbersWhomBribeGiven.indices){

        val value = numbersWhomBribeGiven[i]

        if(value < maxValue){
            totalNoOfBribes+=1
            continue
        }

        maxValue = value
    }

    result.add(totalNoOfBribes.toString())
    /*println("Total No of Bribes : $totalNoOfBribes")
    println("Numbers whom bribe Given : $numbersWhomBribeGiven")*/
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    result = ArrayList()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()

        val q = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

        minimumBribes2(q)
    }

     print(result.joinToString("\n"))
}
