package programs

fun main() {
    val myCircularQueue = MyCircularQueue(3)
    println(myCircularQueue.enQueue(1)) // return True
    println(myCircularQueue.enQueue(2)) // return True
    println(myCircularQueue.enQueue(3)) // return True
    println(myCircularQueue.enQueue(4)) // return False
    println(myCircularQueue.Rear()) // return 3
    println(myCircularQueue.isFull()) // return True
    println(myCircularQueue.deQueue()) // return True
    println(myCircularQueue.enQueue(4)) // return True
    println(myCircularQueue.Rear())// return 4

}

class MyCircularQueue(k: Int) {

    private var tail: ListNode? = null
    private var count = 0
    private val k = k

    fun enQueue(value: Int): Boolean {

        if (isFull())
            return false

        if (isEmpty()) {
            tail = ListNode(value)
            tail!!.next = tail
        } else {
            val newNode = ListNode(value)
            val firstNode = tail!!.next
            tail!!.next = newNode
            newNode.next = firstNode
            tail = newNode
        }

        count++
        return true
    }

    fun deQueue(): Boolean {

        if (isEmpty())
            return false

        if (count == 1) {
            tail = null
        } else {
            val firstNode = tail!!.next
            tail!!.next = firstNode!!.next
            firstNode.next = null
        }

        count--
        return true
    }

    fun Front(): Int {
        if (isEmpty()) return -1
        return tail!!.next!!.`val`
    }

    fun Rear(): Int {
        if (isEmpty()) return -1
        return tail!!.`val`
    }

    fun isEmpty(): Boolean {
        return tail == null
    }

    fun isFull(): Boolean {
        return count == k
    }

}