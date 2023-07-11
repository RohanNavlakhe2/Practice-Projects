package programs

fun main(){
  println(threeSum(intArrayOf(0,0,0)))
}

fun threeSum(nums: IntArray): List<List<Int>> {
     val set = mutableSetOf<MutableList<Int>>()

    for(i in 0..nums.size-3){
        for(j in i+1..nums.size-2){
            for(k in j+1..nums.size-1){
                if(nums[i] + nums[j] + nums[k] == 0){
                    set.add(
                        mutableListOf(nums[i],nums[j],nums[k]).apply { sort() }
                    )
                }
            }
        }
    }

    return set.toList()
}