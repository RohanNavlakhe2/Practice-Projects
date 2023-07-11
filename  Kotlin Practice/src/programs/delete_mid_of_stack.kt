package programs

import java.util.*


fun main() {
    val s = Stack<Int?>()
    s.push(10)
    s.push(20)
    s.push(30)
    s.push(40)
    s.push(50)
    deleteMid(s,s.size)
}

fun deleteMid(s: Stack<Int?>?, sizeOfStack: Int) {
    s?.removeAt(((sizeOfStack + 1) / 2) - 1)
    println(s)

}