package programs

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.math.abs
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'rotLeft' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY a
 *  2. INTEGER d
 */

/*fun rotLeft(a: Array<Int>, d: Int): Array<Int> {

    var arr = a
    val tempArr = IntArray(arr.size)

    for(count in 1..d){

        var index0Value = 0
        for(index in 0..arr.size-2){

            if(index == 0){
                index0Value = arr[index]
            }

            tempArr[index] = arr[index + 1]
        }

        tempArr[arr.size-1] = index0Value
        arr = tempArr.toTypedArray()
    }

    return arr

}*/


fun rotLeft(a: Array<Int>, d: Int): Array<Int> {

    var arr = a
    val tempArray = IntArray(arr.size)

    for(index in arr.indices){
        var newPos = index - d
        if(newPos < 0)
            newPos += arr.size

        tempArray[newPos] = arr[index]
    }
    return tempArray.toTypedArray()
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val d = first_multiple_input[1].toInt()

    val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = rotLeft(a, d)

    println(result.joinToString(" "))
}
