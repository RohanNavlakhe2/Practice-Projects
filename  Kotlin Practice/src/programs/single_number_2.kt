package programs

fun main() {
    println(10 xor 20 xor 10)
    println(20 xor 20)
    println(20 and 20)
    println(20 or 20)
    println(10 xor 20 xor 15)
    println(10 xor 20 xor 25)
    println(30 xor 25)
    println(30 xor 35)
    println(30 xor 40)
    println(30 xor 29)
    println(30 xor 31)
    println(2.inv())
    println((-3).inv())
    println()

}

fun singleNumber2(nums: IntArray): Int {

    val set = HashSet<Int>()

    nums.forEachIndexed { index, value ->
        if (!set.add(value)) {
            set.remove(value)
        }
    }

    return set.first()
}