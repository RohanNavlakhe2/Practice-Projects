package programs

fun main() {
    println(longestSubarray(intArrayOf(1, 1, 0, 1)))
    println(longestSubarray(intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1)))
    println(longestSubarray(intArrayOf(1, 1, 1)))
}

fun longestSubarray(nums: IntArray): Int {
    var previousCount = 0
    var result = 0
    var currentCount = 0

    nums.forEachIndexed { index, num ->

        if (num == 1) {
            currentCount++
        } else if (num == 0) {
            result = Math.max(result, currentCount + previousCount)
            previousCount = currentCount
            currentCount = 0
        }
    }

    result = Math.max(result, currentCount + previousCount)
    return if (currentCount == nums.size) currentCount - 1 else result
}