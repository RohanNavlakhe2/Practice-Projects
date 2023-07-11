package programs

fun main() {
    var start = 0L
    var end = 0L

    start = System.currentTimeMillis()
    println(groupAnagrams2(arrayOf("eat","tea","tan","ate","nat","bat")))
    end = System.currentTimeMillis()

    println(end-start)


}

fun groupAnagrams2(strs: Array<String>): List<List<String>> {
    val map = HashMap<List<Char>, MutableList<String>>()

    for (i in strs.indices) {

         val sortedCharArray =  strs[i].toCharArray().sorted()

        if (map[sortedCharArray] == null) {
            map[sortedCharArray] = mutableListOf()
        }

        map[sortedCharArray] = map[sortedCharArray]!!.apply {
            add(strs[i])
        }
    }

    return map.values.toList()
}