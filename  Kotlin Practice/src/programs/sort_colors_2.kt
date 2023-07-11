package programs

fun main() {
 sortColors2(intArrayOf(2,0,2,1,1,0))
 sortColors2(intArrayOf(2,0,1))
}

fun sortColors2(nums: IntArray): Unit {

    var countOf1 = 0
    var countOf2 = 0

    for(i in nums.indices){

        if(nums[i] == 1){
            countOf1++
        }

        if (nums[i] == 2){
            countOf2++
        }

        when {
            i + countOf1 + countOf2 < nums.size -> {
                nums[i] = 0
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