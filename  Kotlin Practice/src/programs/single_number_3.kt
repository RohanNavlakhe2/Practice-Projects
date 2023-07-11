package programs

fun main(){
  println(10 xor 20 xor 10)
  println(20 xor 20 xor 20)


}

fun singleNumber3(nums: IntArray): Int {

    var result = 0

    for(i in nums.indices){
        result = result xor nums[i]
    }

    return result
}