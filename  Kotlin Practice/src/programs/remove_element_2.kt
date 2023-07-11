package programs

import java.util.*

fun main(){
    val nums = intArrayOf(0,1,2,2,3,0,4,2)
    val value = 2
    val k = removeElement2(nums,value)

    println("Result : ")
    println("Nums : ${nums.contentToString()}, K : $k")
}

fun removeElement2(nums: IntArray, `val`: Int): Int {

    if(`val` > 50){
        return nums.size
    }

    var start:Int? = null
    var end = nums.size - 1
    var k = 0

    for(index in nums.indices){
        if(nums[index] == `val`){

            nums[end] = nums[index]
            k++
            if(start == null){
                start = index
            }
        }else if(start!=null){

            nums[start] = nums[index]

            start += 1

        }
    }

    return if(k == 0) nums.size else nums.size - k
}