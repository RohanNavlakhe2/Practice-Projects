package programs

fun main() {
    println(threeSum3(intArrayOf(-1,0,1,2,-1,-4)))
    println(threeSum3(intArrayOf(0,1,1)))
    println(threeSum3(intArrayOf(0,0,0)))
    println(threeSum3(intArrayOf(-1,0,1,0)))

}

fun threeSum3(nums: IntArray): List<List<Int>> {
    nums.sort()
    println(nums.contentToString())
    val set = HashSet<List<Int>>()

    var i = 0

    while(i<nums.size && nums[i] <= 0){
        var j = nums.lastIndex
        while(j>i && nums[j] >= 0){
            val requiredThirdNo = 0 - (nums[i] + nums[j])
            if(requiredThirdNo >= 0){
                var k = nums.lastIndex
                while ( k>=0 && requiredThirdNo <= nums[k]){
                    if(requiredThirdNo == nums[k] && k!=j && k!=i){
                        set.add(
                            mutableListOf(nums[i],nums[j],requiredThirdNo).apply { sort() }
                        )
                        break
                    }
                    k--
                }
            }else{
                var k = 0
                while(k<nums.size && requiredThirdNo >= nums[k]){
                    if(requiredThirdNo == nums[k] && k!=j && k!=i){
                        set.add(
                            mutableListOf(nums[i],nums[j],requiredThirdNo).apply { sort() }
                        )
                        break
                    }
                    k++
                }
            }
            j--
        }
        i++
    }

    return set.toList()
}

