package programs


fun main() {

    val map = LinkedHashMap<Int, Int>()
    val input = intArrayOf(1, 5, 2, 1, 3, 9, 5, 8, 3)

    input.forEach { num ->
        if (map[num] == null) {
            map[num] = 1
        } else {
            map[num] = map[num]!! + 1
        }

    }

    input.forEach {
        if(map[it]!! > 1){
            print("$it ")
        }
    }
}










