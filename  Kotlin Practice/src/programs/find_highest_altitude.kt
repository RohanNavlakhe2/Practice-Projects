package programs

fun main() {
  println(largestAltitude(intArrayOf(-5,1,5,0,-7)))
  println(largestAltitude(intArrayOf(-4,-3,-2,-1,4,3,2)))
}

fun largestAltitude(gain: IntArray): Int {
    var result = 0
    var sum = 0

    gain.forEach { num ->
        sum += num
        result = Math.max(result,sum)
    }

    return result
}