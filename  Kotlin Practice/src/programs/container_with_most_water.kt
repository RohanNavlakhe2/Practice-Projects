package programs

fun main() {
  println(maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
  println(maxArea(intArrayOf(1,5,6,3,4,2)))
  println(maxArea(intArrayOf(1,1)))
}

fun maxArea(height: IntArray): Int {

    var start = 0
    var end = height.lastIndex

    var result = Integer.MIN_VALUE

    while(start < end){
        val startValue = height[start]
        val endValue = height[end]

        val waterLevel = (end - start) *  Math.min(startValue,endValue)
        result = Math.max(result,waterLevel)

        when {
            startValue < endValue -> {
                start++
            }
            endValue < startValue -> {
                end--
            }
            else -> {
                start++
                end--
            }
        }

    }

    return result


}