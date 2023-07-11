package programs

class MyCircularQueue2(k: Int) {

    private val queue = IntArray(k)
    private var rear = 0
    private var front = -1

    fun enQueue(value: Int): Boolean {

        if(isFull())
            return false

        queue[rear] = value
        rear = (rear + 1)  % queue.size
        return true
    }

    fun deQueue(): Boolean {
        if(isEmpty())
            return false
        front = (front + 1) % queue.size
        TODO()

    }

    fun Front(): Int {
        TODO()
    }

    fun Rear(): Int {
        TODO()
    }

    fun isEmpty(): Boolean {
        TODO()
    }

    fun isFull(): Boolean {
        return rear == front
    }

}