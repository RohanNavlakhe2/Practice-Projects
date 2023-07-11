package programs

fun main() {
    println(minRemoveToMakeValid2("lee(t(c)o)de)"))
    println(minRemoveToMakeValid2("a)b(c)d"))
    println(minRemoveToMakeValid2("))(("))
}

fun minRemoveToMakeValid2(s: String): String {

    val resultStr = StringBuilder(s)
    var openBraceCount = 0
    var closeBraceCount = 0

    var index = 0
    while (index <= resultStr.lastIndex){

        val char = resultStr[index]

        if (char == '(')
            openBraceCount++

        if (char == ')') {

            closeBraceCount++

            if (closeBraceCount > openBraceCount) {
                resultStr.deleteCharAt(index)
                closeBraceCount--
                index--
            }
        }

        index++
    }

    openBraceCount = 0
    closeBraceCount = 0

    var i = resultStr.lastIndex
    while (i>=0){

        val char = resultStr[i]

        if (char == ')')
            closeBraceCount++

        if (char == '(') {
            openBraceCount++
            if (openBraceCount > closeBraceCount) {
                resultStr.deleteCharAt(i)
                openBraceCount--
                //i++
            }
        }

        i--
    }

    return resultStr.toString()
}