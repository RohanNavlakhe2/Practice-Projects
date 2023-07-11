package programs

fun main() {
    println(frequencySort("abadccabpoba"))
    println(frequencySort("tree"))
    println(frequencySort("cccaaa"))
    println(frequencySort("Aabb"))
}

fun frequencySort(s: String): String {

    val charMap = HashMap<Char, StringBuffer>()

    s.forEach { char ->
        if (charMap[char] == null) {
            charMap[char] = StringBuffer()
        }

        charMap[char] = charMap[char]!!.apply {
            append(char)
        }
    }

    val sortedList =
        charMap.values.toList().sortedWith(Comparator { o1, o2 -> o2.length.compareTo(o1.length) })

    return sortedList.joinToString(separator = "")
}