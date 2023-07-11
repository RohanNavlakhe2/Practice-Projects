package programs

fun main(){
    println(containsNearbyDuplicate2(intArrayOf(1,2,3,1,2,3),2))
}

fun containsNearbyDuplicate2(nums: IntArray, k: Int): Boolean {

   val numMap = HashMap<Int,Int>()

   for(i in nums.indices){

       if(numMap[nums[i]] != null){
           if(i - numMap[nums[i]]!! <= k )
               return true
       }

       numMap[nums[i]] = i

   }

    return false
}