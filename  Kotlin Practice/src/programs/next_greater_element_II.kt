package programs

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashSet

fun main() {
    println(nextGreaterElementII(intArrayOf(10, 15, 2, 8, 5)).contentToString())
    println(nextGreaterElementII(intArrayOf(1, 2, 1)).contentToString())
    println(nextGreaterElementII(intArrayOf(1, 2)).contentToString())
    println(nextGreaterElementII(intArrayOf(1, 2, 3, 4, 3)).contentToString())
    println(nextGreaterElementII(intArrayOf(1, 1, 1, 1, 1)).contentToString())
    println(nextGreaterElementII(intArrayOf(100, 1, 11, 1, 120, 111, 123, 1, -1, -100)).contentToString())
    println(nextGreaterElementII(intArrayOf(1, -1,1)).contentToString())
}

fun nextGreaterElementII(nums: IntArray): IntArray {

    if (nums.size == 1) {
        return intArrayOf(-1)
    }

    val map = HashMap<Int, Int>()
    val stack = Stack<Int>()
    stack.push(0)
    val resultArr = IntArray(nums.size)

    var i = 1
    var count = 0
    while (stack.peek() != i) {

        val currentValue = nums[i]
        val peekValueAtStack = nums[stack.peek()]
        if (currentValue > peekValueAtStack) {

            map[stack.pop()] = currentValue

            if (stack.isEmpty()) {
                if (count <= nums.size) {
                    stack.push(i)
                    count++
                }
                i++
            }
        } else {
            if (count <= nums.size) {
                stack.push(i)
                count++
            }
            i++
        }

        i %= nums.size
    }

    nums.forEachIndexed { index, num ->
        resultArr[index] = map[index] ?: -1
    }

    return resultArr
}