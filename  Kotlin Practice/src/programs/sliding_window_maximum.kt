package programs

import java.util.*

fun main(){
    println(maxSlidingWindow(intArrayOf(5,30,10,40,5),3).contentToString())
    println(maxSlidingWindow(intArrayOf(1,3,-1,-3,5,3,6,7),3).contentToString())
    println(maxSlidingWindow(intArrayOf(1),1).contentToString())
}

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {

    val result = IntArray(nums.size - k + 1)
    val stack = ArrayDeque<Int>()
    val tempStack = ArrayDeque<Int>()

    stack.push(0)

    for(i in 1 until k){

        val currentNo = nums[i]

        while (stack.peek() != null && nums[stack.peek()] > currentNo){
            tempStack.push(stack.pop())
        }
        stack.push(i)

        while (tempStack.isNotEmpty()){
            stack.push(tempStack.pop())
        }
    }

    result[0] = nums[stack.peek()]

    for(i in 1..nums.size-k){

        val newItem = nums[i+k-1]

        while(stack.peek() != i-1){
            tempStack.push(stack.pop())
        }

        stack.pop()

        while (tempStack.isNotEmpty()){
            stack.push(tempStack.pop())
        }

        while (stack.peek() != null && nums[stack.peek()] > newItem){
            tempStack.push(stack.pop())
        }

        stack.push(i+k-1)

        while (tempStack.isNotEmpty()){
            stack.push(tempStack.pop())
        }

        result[i] = nums[stack.peek()]

    }

    return result
}