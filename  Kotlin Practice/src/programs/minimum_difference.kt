package programs

fun main() {
  println(minimumDifference(intArrayOf(90),1))
}

fun minimumDifference(nums: IntArray, k: Int): Int {

    nums.sort()

   var result = Integer.MAX_VALUE

    for (i in 0..nums.size - k) {
        val diffBetweenHigherAndLowerValue = nums[i+k-1] - nums[i]
        result = if(diffBetweenHigherAndLowerValue < result) diffBetweenHigherAndLowerValue else result
    }

    return result
}