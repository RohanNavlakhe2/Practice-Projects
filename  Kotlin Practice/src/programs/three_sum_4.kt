package programs

fun main() {
    println(threeSum4(intArrayOf(-1,0,1,2,-1,-4)))
    println(threeSum4(intArrayOf(0,1,1)))
    println(threeSum4(intArrayOf(0,0,0)))
    println(threeSum4(intArrayOf(-1,0,1,0)))

}

fun threeSum4(nums: IntArray): List<List<Int>> {

    nums.sort()
    println(nums.contentToString())

    val map = HashMap<Int,MutableList<Int>>()
    for(i in nums.indices){
        val value = nums[i]
        if(map[value] == null){
            map[value] = mutableListOf()
        }
        map[value] = map[value]!!.apply {
            add(i)
        }
    }

    println(map)


    val set = HashSet<List<Int>>()

    var i = 0

    while(i<nums.size && nums[i] <= 0){
        var j = nums.lastIndex
        while(j>i && nums[j] >= 0){
            val requiredThirdNo = 0 - (nums[i] + nums[j])
            if(map[requiredThirdNo] != null){
                for(requiredNoPosition in map[requiredThirdNo]!!){
                    if(requiredNoPosition != i && requiredNoPosition != j){
                        set.add(
                          mutableListOf(nums[i],nums[j],requiredThirdNo).apply { sort() }
                        )
                        break
                    }
                }
            }
            j--
        }
        i++
    }

    return set.toList()
}

