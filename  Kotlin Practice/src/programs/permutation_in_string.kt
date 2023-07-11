package programs

fun main() {
  println(checkInclusion("ab","eidbaooo"))
  println(checkInclusion("ab","eidboaoo"))
}

fun checkInclusion(s1: String, s2: String): Boolean {
    val s1Map = HashMap<Char, Int>()
    val resultMap = HashMap<Char, Pair<MutableList<Int>, Int>>()

    var start = 0

    s1.forEach { char ->
        if (s1Map[char] == null) {
            s1Map[char] = 1
        } else {
            s1Map[char] = s1Map[char]!! + 1
        }
    }

    while (start + s1.length <= s2.length) {

        var success = true

        for (i in start until start + s1.length) {
            val char = s2[i]

            //If this char does not exists in s1 string
            if (s1Map[char] == null) {
                start++
                resultMap.clear()
                success = false
                break
            }

            if (resultMap[char] == null) {
                resultMap[char] = Pair(mutableListOf(i), 1)
            } else {
                resultMap[char] = resultMap[char]!!.copy(
                    resultMap[char]!!.first.apply { add(i) },
                    resultMap[char]!!.second.plus(1)
                )
            }

            if (resultMap[char]!!.second > s1Map[char]!!) {
                start = resultMap[char]!!.first[0] + 1
                resultMap.clear()
                success = false
                break
            }
        }

        if(success)
            return success
    }

    return false

}