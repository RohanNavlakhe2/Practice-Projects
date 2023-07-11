package programs

fun main() {
    println(minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
    println(minSubArrayLen(4, intArrayOf(1,4,4)))
    println(minSubArrayLen(11, intArrayOf(1,1,1,1,1,1,1,1)))
}

fun minSubArrayLen(target: Int, nums: IntArray): Int {

    var left = 0
    var right = 0
    var sum = nums[left]
    var result = 0

    if (sum >= target)
        return 1

    while (right < nums.size) {

        if (sum >= target) {
            result = right - left + 1
            if (result == 1)
                return result
            sum -= nums[left]
            left++
        } else {
            right++

            if (right < nums.size)
                sum += nums[right]

            if (result != 0) {
                sum -= nums[left]
                left++
            }
        }
    }

    return result

}