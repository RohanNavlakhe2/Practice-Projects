package programs

fun main() {
    println(increasingTriplet(intArrayOf(1,2,3,4,5)))
    println(increasingTriplet(intArrayOf(5,4,3,2,1)))
    println(increasingTriplet(intArrayOf(2,1,5,0,4,6)))
}

fun increasingTriplet(nums: IntArray): Boolean {

    if (nums.size < 3)
        return false

    var minValue = Integer.MAX_VALUE
    //var count = 1
    var secondValue: Int

    for (i in 0..nums.lastIndex - 2) {
        if(nums[i] < minValue){
            minValue = nums[i]
            secondValue = Integer.MAX_VALUE
            for (j in i + 1..nums.lastIndex) {

                if(nums[j] > secondValue){
                    return true
                }

                if(nums[j] > nums[i]){
                    secondValue = nums[j]
                    //count++
                }
            }
        }

    }

    return false

}