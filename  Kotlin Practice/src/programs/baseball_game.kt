package programs

import java.util.*

fun main(){
  println(calPoints(arrayOf("5","2","C","D","+")))
  println(calPoints(arrayOf("5","-2","4","C","D","9","+","+")))
  println(calPoints(arrayOf("1","C")))
}

fun calPoints(operations: Array<String>): Int {

    //val stack = Stack<Int>()
    val stack = ArrayDeque<Int>()
    var total = 0

    operations.forEach {operation ->
        when(operation){

            "+" -> {
                val element = stack.pop()
                val newElement = element + stack.peek()
                stack.push(element)
                stack.push(newElement)
                total += stack.peek()
            }

            "D" -> {
                stack.push(stack.peek() * 2)
                total += stack.peek()
            }

            "C" -> {
                total -= stack.peek()
                stack.pop()
            }

            else -> {
                stack.push(operation.toInt())
                total += stack.peek()

            }
        }
    }

    return total

}