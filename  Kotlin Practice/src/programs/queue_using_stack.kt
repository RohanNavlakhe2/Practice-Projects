package programs

import java.util.*

fun main(){
    val queue = MyQueue()
    queue.push(10)
    queue.push(20)
    queue.push(30)
    println(queue.peek())
    println(queue.pop())
    println(queue.pop())
    println(queue.pop())

}

class MyQueue() {

    var stack = Stack<Int>()
    var tempStack = Stack<Int>()

    fun push(x: Int) {

        while (stack.isNotEmpty()){
            tempStack.push(stack.pop())
        }

        stack.push(x)

        while(tempStack.isNotEmpty()){
            stack.push(tempStack.pop())
        }
    }

    fun pop(): Int {
        return stack.pop()
    }

    fun peek(): Int {
        return stack.peek()
    }

    fun empty(): Boolean {
        return stack.isEmpty()
    }

}