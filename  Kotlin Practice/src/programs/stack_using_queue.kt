package programs

fun main(){
    val myStack = MyStack()
    myStack.push(10)
    myStack.push(20)
    println(myStack.top())
    println(myStack.pop())
    myStack.printStack()
    println(myStack.top())
    println(myStack.pop())


}

class MyStack() {

    //data class Node(var data: Int, var next: Node? = null)

    private var mainHead: ListNode? = null
    private var mainTail: ListNode? = null

    fun push(x: Int) {
        if (mainTail == null) {
            mainTail = ListNode(x)
            mainHead = mainTail
            return
        }

        mainTail!!.next = ListNode(x)
        mainTail = mainTail!!.next
    }

    fun pop(): Int {

        if(mainHead === mainTail){
            val value = mainHead!!.`val`
            mainHead = null
            mainTail = null
            return value
        }

        val tempTail = mainTail
        mainTail!!.next = mainHead

        while(mainHead !== tempTail){
            //mainTail!!.next = mainHead
            mainTail = mainTail!!.next
            mainHead = mainHead!!.next
        }

        val temp = mainHead!!.next
        mainHead!!.next = null
        mainHead = temp
        mainTail!!.next = null

        return tempTail!!.`val`
    }

    fun top(): Int {

        if(mainHead === mainTail){
            return mainHead!!.`val`
        }

        val tempTail = mainTail
        mainTail!!.next = mainHead

        while(mainHead !== tempTail){
            //mainTail!!.next = mainHead
            mainTail = mainTail!!.next
            mainHead = mainHead!!.next
        }

        val value = mainHead!!.`val`
        val temp = mainHead!!.next
        mainHead!!.next = null
        mainHead = temp
        mainTail = mainTail!!.next

        return value
    }

    fun empty(): Boolean {
        return mainHead == null
    }

    fun printStack(){
        printLinkedList(mainHead)
    }

}