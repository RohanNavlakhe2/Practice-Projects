package programs

import java.lang.StringBuilder
import java.util.*

fun main() {
    println(decodeString("3[a2[c]]"))
    println(decodeString("3[a]2[bc]"))
    println(decodeString("2[abc]3[cd]ef"))
    println(decodeString("abc3[cd]"))
}

fun decodeString(s: String): String {

    val stack = ArrayDeque<String>()
    var foundNo = false

    for(i in s.lastIndex downTo -1){
        val currentChar = if(i == -1) ' ' else s[i]
        val currentCharInt = currentChar.toInt()
        val number = StringBuilder()
        val str = StringBuilder()

        if(foundNo && currentCharInt !in 48..57){

            while (stack.peek() != "["){
                number.append(stack.pop())
            }

            stack.pop()

            while (stack.peek() != "]"){
                str.append(stack.pop())
            }

            stack.pop()


            for(j in 1..number.toString().toInt()){
                stack.push(str.toString())
            }

            foundNo = false
        }

        if(i != -1){
            stack.push(currentChar.toString())
        }

        if(currentCharInt in 48..57){
            //means current char is a number
            foundNo = true
        }

    }

    val result = StringBuilder()
    while (stack.isNotEmpty()){
        result.append(stack.pop())
    }

    return result.toString()
}