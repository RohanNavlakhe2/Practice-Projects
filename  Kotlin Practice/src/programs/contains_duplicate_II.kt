package programs

fun main(){
    println(containsNearbyDuplicate(intArrayOf(1,2,3,1,2,3),2))
}

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
   for(i in nums.indices){
       for(j in i+1 until nums.size){
           if(nums[i] == nums[j] && j-i <= k)
               return true
       }
   }

    return false
}