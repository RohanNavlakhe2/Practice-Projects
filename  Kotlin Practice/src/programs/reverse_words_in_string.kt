package programs

fun main() {
    println(reverseWords("  Ro   nav  "))
    println(reverseWords("the sky is blue"))
    println(reverseWords("  hello world  "))
    println(reverseWords("a good   example"))
}

fun reverseWords(s: String): String {
    val strArr = s.split(" ")
    val str = StringBuilder()
    for (i in strArr.lastIndex downTo 0) {
        val value = strArr[i]
        if (value.isNotEmpty()) {
            str.append(value)
            str.append(" ")
        }
    }
    return str.toString().trimEnd()
}