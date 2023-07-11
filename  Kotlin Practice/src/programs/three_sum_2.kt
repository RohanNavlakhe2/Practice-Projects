package programs

fun main() {
    println(threeSum2(intArrayOf(-1,0,1,2,-1,-4)))
}

fun threeSum2(nums: IntArray): List<List<Int>> {
    nums.sort()
    println(nums.contentToString())
    val map = HashMap<Int,MutableSet<MutableList<Int>>>()

    var i = 0

    while(nums[i] < 0 ){
        var j = nums.lastIndex
        while(nums[j] >= 0){
            val requiredThirdNo = 0 - (nums[i] + nums[j])
            if(map[requiredThirdNo] == null){
                map[requiredThirdNo] = mutableSetOf()
            }
            map[requiredThirdNo] = map[requiredThirdNo]!!.apply {
                add(
                    mutableListOf(nums[i],nums[j]).apply { sort() }
                )
            }
            j--
        }
        i++
    }

    println(map)

    return emptyList()
}