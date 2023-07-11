package programs

fun main(){
  //println(findMaxAverage2(intArrayOf(1,0,1,4,2),4))
    /*var a: Double = 2/4.toDouble()
    println(a)*/

    //Both are same
    val a:Long =  1_00_000
    val b = 100000


    println(a)
    println(b)

}

fun findMaxAverage2(nums: IntArray, k: Int): Double {

    if(nums.size == 1){
        return nums[0].toDouble()
    }

    var result:Double  =  Integer.MIN_VALUE.toDouble()
    var windowSum = nums[0]

   for(i in 0..nums.size - k){

       if(i==0){
           var j=1
           while(j<k){
               windowSum += nums[j]
               j++
           }
       }else{
           windowSum = windowSum-nums[i-1]+nums[i+k-1]
       }

       val windowAvg = windowSum/k.toDouble()
       result = if(result > windowAvg) result else windowAvg
   }

    return result
}

