package programs

import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

/*
 * Complete the 'programs.sockMerchant' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER_ARRAY ar
 */

fun sockMerchant(n: Int, ar: Array<Int>): Int {
    // Write your code here
    var pairs = 0
    val li = ar.toList()
    li.distinct().forEach {
        pairs += li.count { ele -> ele == it }/2
    }
    return pairs
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val ar = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}
