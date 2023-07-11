package programs

fun main() {
    println(jump(intArrayOf(2, 3, 1, 1, 4)))
    println(jump(intArrayOf(2, 3, 0, 1, 4)))
}

fun jump(nums: IntArray): Int {
    var targetIndex = nums.lastIndex
    var jumpCount = 0

    while (targetIndex != 0) {
        for (i in 0 until targetIndex) {
            val num = nums[i]
            if (i + num >= targetIndex) {
                jumpCount++
                targetIndex = i
                break
            }
        }
    }

    return jumpCount
}