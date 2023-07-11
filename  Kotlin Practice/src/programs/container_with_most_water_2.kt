package programs

fun main() {
  println(maxArea2(intArrayOf(1,8,6,2,5,4,8,3,7)))
  println(maxArea2(intArrayOf(1,5,6,3,4,2)))
  println(maxArea2(intArrayOf(1,1)))
}

fun maxArea2(height: IntArray): Int {

    var start = 0
    var end = height.lastIndex

    var result = Integer.MIN_VALUE

    while(start < end){

        val previousStartValue = if(start != 0) height[start - 1] else Integer.MIN_VALUE
        val previousEndValue = if(end != height.lastIndex) height[end + 1] else Integer.MIN_VALUE

        val startValue = height[start]
        val endValue = height[end]

        if(startValue < previousStartValue || endValue < previousEndValue){

            if(startValue < previousStartValue){
                start++
            }

            if(endValue < previousEndValue){
                end--
            }

            continue
        }


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