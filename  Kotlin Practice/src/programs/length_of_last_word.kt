package programs

fun main() {

}

fun lengthOfLastWord(s: String): Int {

    var count = 0

    for (i in s.lastIndex downTo 0) {
        val char = s[i]
        if(char != ' '){
            count++
        }else if(count != 0 && char == ' ')
            return count
    }

    return count
}