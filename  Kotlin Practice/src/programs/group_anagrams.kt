package programs

fun main() {
    var start = 0L
    var end = 0L

    start = System.currentTimeMillis()
    println(groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat")))
    end = System.currentTimeMillis()

    println(end-start)

}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = HashMap<String, MutableList<String>>()

    for (i in strs.indices) {

         val sortedString = String(strs[i].toCharArray().sortedArray())

        if (map[sortedString] == null) {
            map[sortedString] = mutableListOf()
        }

        map[sortedString] = map[sortedString]!!.apply {
            add(strs[i])
        }
    }

    return map.values.toList()
}