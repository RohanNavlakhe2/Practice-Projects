package programs

fun main() {
    val start  = System.currentTimeMillis()
    swap()
    val end = System.currentTimeMillis()

    println(end - start)
}

fun swap() {

    var a = 10_00_000
    var b = 15_00_000

    println("a : $a , b : $b")

    val temp = a
    a = b
    b = temp
    println("a : $a , b : $b")
}

fun swap2() {

    var a = 10_00_000
    var b = 15_00_000

    println("a : $a , b : $b")

    a += b
    b = a - b
    a -= b

    println("a : $a , b : $b")
}