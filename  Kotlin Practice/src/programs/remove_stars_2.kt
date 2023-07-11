package programs

import java.lang.StringBuilder
import java.util.*

fun main() {
    println(removeStars2("leet**cod*e"))
    println(removeStars2("erase*****"))
    println(removeStars2("erase****"))

}

fun removeStars2(s: String): String {

    val stack = ArrayDeque<Char>()

    for(ch in s){
        if(ch == '*'){
            stack.pop()
            continue
        }

        stack.push(ch)
    }

    val sb = StringBuilder()

    while(stack.isNotEmpty()){
        sb.append(stack.pollLast())
    }

    return sb.toString()
}