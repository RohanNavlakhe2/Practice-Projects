package programs

import java.util.*

fun main(){
    println(maxSlidingWindow2(intArrayOf(5,30,10,40,5),3).contentToString())
    println(maxSlidingWindow2(intArrayOf(1,3,-1,-3,5,3,6,7),3).contentToString())
    println(maxSlidingWindow2(intArrayOf(1),1).contentToString())
}

fun maxSlidingWindow2(nums: IntArray, k: Int): IntArray {

    val result = IntArray(nums.size - k + 1)
    var biggestElementIndex = findBiggestElementIndex(nums,0,k-1)
    result[0] = nums[biggestElementIndex]

    for(i in 1..nums.size-k){
        if(i<=biggestElementIndex){
            if(nums[biggestElementIndex] > nums[i+k-1]){
                result[i] = nums[biggestElementIndex]
            }else{
                result[i] = nums[i+k-1]
                biggestElementIndex = i+k-1
            }
        }else if(nums[i+k-1] > nums[biggestElementIndex]){
            result[i] = nums[i+k-1]
            biggestElementIndex = i+k-1
        }else{
            biggestElementIndex = findBiggestElementIndex(nums,i,i+k-1)
            result[i] = nums[biggestElementIndex]
        }
    }

    return result
}

private fun findBiggestElementIndex(nums: IntArray, startIndex:Int, endIndex: Int):Int{

    var maxIndex = startIndex

    for(i in startIndex+1..endIndex){
        if(nums[i] > nums[maxIndex]){
            maxIndex = i
        }
    }

    return maxIndex
}