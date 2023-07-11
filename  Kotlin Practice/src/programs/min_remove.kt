package programs

fun main() {
  println(minRemoveToMakeValid("lee(t(c)o)de)"))
  println(minRemoveToMakeValid("a)b(c)d"))
  println(minRemoveToMakeValid("))(("))
}

fun minRemoveToMakeValid(s: String): String {

    val tempStr = StringBuilder()
    val resultStr = StringBuilder()
    var openBraceCount = 0
    var closeBraceCount = 0

    s.forEach { char ->

        if(char != ')'){
            tempStr.append(char)
        }

        if (char == '(')
            openBraceCount++
        if(char == ')'){
            closeBraceCount++
            if(closeBraceCount <= openBraceCount){
                tempStr.append(char)
            }else{
                closeBraceCount--
            }
        }
    }

    openBraceCount = 0
    closeBraceCount = 0

    for(i in tempStr.lastIndex downTo 0){
        val char = tempStr[i]
        if(char != '('){
            resultStr.append(char)
        }

        if (char == ')')
            closeBraceCount++
        if(char == '('){
            openBraceCount++
            if(openBraceCount <= closeBraceCount){
                resultStr.append(char)
            }else{
                openBraceCount--
            }
        }
    }

    return resultStr.toString().reversed()
}