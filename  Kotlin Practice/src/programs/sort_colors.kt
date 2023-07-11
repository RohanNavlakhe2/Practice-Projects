package programs

fun main() {
 sortColors(intArrayOf(2,0,2,1,1,0))
 sortColors(intArrayOf(2,0,1))
}

fun sortColors(nums: IntArray): Unit {
    var countOf0 = 0
    var countOf1 = 0
    var countOf2 = 0

    nums.forEach {
        when(it){
            0 -> countOf0++
            1 -> countOf1++
            2 -> countOf2++
        }
    }

    for(i in nums.indices){
        when {
            countOf0 > 0 -> {
                nums[i] = 0
                countOf0--
            }
            countOf1 > 0 -> {
                nums[i] = 1
                countOf1--
            }
            countOf2 > 0 -> {
                nums[i] = 2
                countOf2--
            }
        }
    }

    println(nums.contentToString())

}