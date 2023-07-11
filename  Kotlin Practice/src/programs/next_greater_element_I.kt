package programs

import java.util.*
import kotlin.collections.HashMap

fun main() {
    println(nextGreaterElement(intArrayOf(2,4), intArrayOf(1,2,3,4)).contentToString())
    println(nextGreaterElement(intArrayOf(4,1,2), intArrayOf(1,3,4,2)).contentToString())
}

fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {

    val map = HashMap<Int,Int>()
    val stack = Stack<Int>()
    val resultArr = IntArray(nums1.size)

    var i = 0
    while (i <= nums2.lastIndex){
        val currentValue = nums2[i]
        if(stack.isNotEmpty() && currentValue > stack.peek()){
            map[stack.pop()] = currentValue
        }else{
            stack.push(currentValue)
            i++
        }
    }

    nums1.forEachIndexed { index, num ->
        resultArr[index] = map[num] ?: -1
    }

    return resultArr
}