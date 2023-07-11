package programs

fun main(){
    println(firstUniqChar("leetcode"))
    println(firstUniqChar("loveleetcode"))
    println(firstUniqChar("aabb"))
}

fun firstUniqChar(s: String): Int {

    val map = HashMap<Char,Boolean>()

    s.forEach {
        map[it] = map[it] == null
    }

    s.forEachIndexed { index, c ->
        if(map[c] == true)
            return index
    }

    return -1
}