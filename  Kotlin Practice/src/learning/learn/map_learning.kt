package learning.learn

fun main() {
    mapTest()
    countCharactersInString("Rohan Navlakhe")
}

fun mapTest() {
    val map = mutableMapOf<Int, String>(15 to "Value", 16 to "B")
    map[1] = "Saurabh"
    map[10] = "Rohan"
    println(map[10])

    map[10] = "A"
    println(map)



    println(map[25])
    map[25] = "A"
    println(map)


    println(map.keys)
    println(map.values)
    map.entries.forEach {
        println("${it.key}=${it.value}")
    }

    println(map.putIfAbsent(10, "N"))

    println(map.replace(25, "Q"))

    println(map.remove(10))


    val num = 10.toString()

    val noOfEntries = map.count {
        it.value.contains("Red", ignoreCase = true)
    }

    val filteredMap = map.filter{
        it.value == "A"
    }

    val notFilteredMap = map.filterNot{
        it.value == "A"
    }

    val keyFilteredMap = map.filterKeys{
        it == 1
    }

    val valueFilteredMap = map.filterValues{
        it == "A"
    }

    val map2 = mapOf<Int, String>()
    //map2[2] = "A"
}

fun countCharactersInString(value: String) {

    val map = mutableMapOf<Char, Int>()

    value.forEach {
        val char = it.toLowerCase()
        val charCount = map[char] ?: 0
        map[char] = charCount + 1
    }

    map.forEach {
        println(it)
    }

}