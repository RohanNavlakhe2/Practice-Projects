package programs

fun main() {
    /*println(reverseWords2("  Ro   nav  "))
    println(reverseWords2("the sky is blue"))
    println(reverseWords2("  hello world  "))
    println(reverseWords2("a good   example"))*/
    println(reverseWords2("I am Rohan Vijay Kumar Navlakhe"))
}

fun reverseWords2(s: String): String {

    var s = s

    var start = 0
    var end = s.lastIndex
    var writeAtStart = 0
    var writeAtEnd = s.lastIndex
    var startStr = StringBuilder()
    var endStr = StringBuilder()

    while(writeAtStart < writeAtEnd){

        val currentCharFromStart = s[start]
        var currentCharFromEnd = s[end]

        if(currentCharFromStart != ' '){
            startStr.append(s[start])
        }

        if(currentCharFromEnd != ' '){
            endStr.append(s[end])
        }


        if(currentCharFromStart == ' '){
            writeAtEnd -= startStr.length
            s = s.replaceRange(writeAtEnd..writeAtEnd + startStr.length," " + startStr)
            writeAtEnd--
            startStr = startStr.clear()
        }

        if(start > end && currentCharFromStart == ' '){
            break
        }

        if(currentCharFromEnd == ' '){
            val reversedEndStr = endStr.reversed().toString()
            s = s.replaceRange(writeAtStart..writeAtStart + reversedEndStr.length,reversedEndStr + " ")
            writeAtStart = writeAtStart + reversedEndStr.length
            writeAtStart++
            endStr = endStr.clear()
        }

        if(start > end && currentCharFromEnd == ' '){
            break
        }

        start++
        end--
    }

    return s
}