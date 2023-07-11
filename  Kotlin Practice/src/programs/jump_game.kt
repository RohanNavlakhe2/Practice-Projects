package programs

fun main() {
  println(canJump(intArrayOf(2,3,1,1,4)))
  println(canJump(intArrayOf(3,2,1,0,4)))
}

fun canJump(nums: IntArray): Boolean {

    var jumpAt = nums.lastIndex

    for (i in nums.lastIndex - 1 downTo 0) {
        val num = nums[i]
        if (i + num >= jumpAt) {
            jumpAt = i
        }
    }

    return jumpAt == 0

}