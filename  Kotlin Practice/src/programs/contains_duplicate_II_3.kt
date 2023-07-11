package programs

fun main(){
    println(containsNearbyDuplicate3(intArrayOf(1,2,3,1,2,3),2))
}

fun containsNearbyDuplicate3(nums: IntArray, k: Int): Boolean {

   val numMap = HashMap<Int,Int>()

   for(i in nums.indices){

       val numberIndex = numMap[nums[i]]

       if(numberIndex != null && i - numberIndex <= k){
           return true
       }

       numMap[nums[i]] = i

   }

    return false
}