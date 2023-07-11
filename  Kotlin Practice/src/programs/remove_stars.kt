package programs

fun main() {
    println(removeStars("leet**cod*e"))
    println(removeStars("erase*****"))
    println(removeStars("erase****"))
}

fun removeStars(s: String): String {

    val chArr = CharArray(s.length)
    var currentCharAt = 0

    for (i in s.indices) {
        val char = s[i]
        if (char == '*') {
            currentCharAt--
            chArr[currentCharAt] = ' '
            continue

        }
        chArr[currentCharAt] = char
        currentCharAt++
    }


    return String(chArr.copyOfRange(0,currentCharAt))
}