package programs

fun main() {
    println(threeSum5(intArrayOf(-1, 0, 1, 2, -1, -4)))
    println(threeSum5(intArrayOf(0, 1, 1)))
    println(threeSum5(intArrayOf(0, 0, 0)))
    println(threeSum5(intArrayOf(-1, 0, 1, 0)))

}

fun threeSum5(nums: IntArray): List<List<Int>> {

    nums.sort()
    println(nums.contentToString())

    val set = HashSet<List<Int>>()

    for (i in nums.indices) {
        val searchFor = -nums[i]
        var start = 0
        var end = nums.lastIndex

        while(start < end){

            if(i == start) {
                start++
                continue
            }
            if(i == end){
                end--
                continue
            }

            val total = nums[start] + nums[end]

            if(total == searchFor){

                set.add(
                    mutableListOf(nums[start],nums[end],nums[i]).apply { sort() }
                )

                start++
                end--

            }else if(total < searchFor){
                start++
            }else{
                end--
            }

        }

    }

    return set.toList()
}

