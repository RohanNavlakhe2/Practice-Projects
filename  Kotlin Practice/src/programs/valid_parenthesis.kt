package programs

import java.util.*

fun main(){
    println(isValid("()"))
    println(isValid("()[]{}"))
    println(isValid("(]"))
}

fun isValid(s: String): Boolean {

    val stack = ArrayDeque<Char>()

    s.forEach { char ->
        if(char == '(' || char == '{' || char == '['){
            stack.push(char)
        }else{
            val topStackChar = stack.peek() ?: return false

            when(char){

                ')' -> {
                    if(topStackChar == '(')
                        stack.pop()
                    else
                        return false
                }

                '}' -> {
                    if(topStackChar == '{')
                        stack.pop()
                    else
                        return false
                }

                ']' -> {
                    if(topStackChar == '[')
                        stack.pop()
                    else
                        return false
                }
            }
        }
    }

    return stack.isEmpty()

}