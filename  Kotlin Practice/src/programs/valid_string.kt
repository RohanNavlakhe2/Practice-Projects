package programs

fun main() {
    println("Is Valid String (()) : ${isValidString("(())")}")
    println("Is Valid String (()( : ${isValidString("(()(")}")
    println("Is Valid String (()( : ${isValidString("(((())")}")
    println("Is Valid String ()(()) : ${isValidString("()(())")}")
}

fun isValidString(string: String): Boolean {

    if (string.length % 2 != 0)
        return false

    var countOfOpenBracket = 0

    for (i in string.indices) {

        if (string[i] == '(')
            countOfOpenBracket += 1

        if (string[i] == ')') {
            for (j in i until i + countOfOpenBracket) {
                try {
                    if (string[j] != ')')
                        return false
                } catch (e: StringIndexOutOfBoundsException) {
                    return false
                }
            }

            if (i == string.lastIndex)
                return true

            countOfOpenBracket = 0
        }

    }

    return false
}

fun countOfString(string: String) {

    val map = HashMap<Char, Int>()

    string.forEach { char ->
        map[char] = (map[char] ?: 0) + 1
    }

    print(map)
}