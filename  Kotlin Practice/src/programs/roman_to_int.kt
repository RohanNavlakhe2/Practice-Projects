package programs

fun main() {
    println(romanToInt("MDLXX"))

}

fun romanToInt(s: String): Int {

    var intValueResult = 0
    var i = 0

    val romans = mapOf(
        Pair("I", 1), Pair("V", 5), Pair("X", 10), Pair("L", 50), Pair("C", 100),
        Pair("D", 500), Pair("M", 1000)
    )

    while (i < s.length) {
        val currentChar = s[i].toString()
        val currentValue = romans[currentChar]!!

        if (i != s.lastIndex && (currentChar == "I" || currentChar == "X" || currentChar == "C")) {
            val nextChar = s[i + 1].toString()
            val nextValue = romans[nextChar]!!

            if (nextValue == currentValue * 5 || nextValue == currentValue * 10) {
                intValueResult += nextValue - currentValue
                i += 2
                continue
            } else
                intValueResult += currentValue
        } else
            intValueResult += currentValue

        i++

    }

    return intValueResult
}