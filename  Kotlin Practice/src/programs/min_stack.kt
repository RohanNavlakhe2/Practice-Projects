package programs

fun main(){
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin()) // return -3

    minStack.pop()
    println(minStack.top()) // return 0

    println(minStack.getMin()) // return -2

}

class MinStack() {

    private val stack = ArrayList<Int>()
    private var min = Integer.MAX_VALUE


    fun push(`val`: Int) {
        stack.add(`val`)
        if(`val` < min){
            min = `val`
        }
    }

    fun pop() {
        val valueToPop = stack[stack.lastIndex]
        stack.removeAt(stack.lastIndex)

        if(valueToPop == min){
            min = Integer.MAX_VALUE
            for(i in stack.indices){
                if(stack[i] < min){
                    min = stack[i]
                }
            }
        }
    }

    fun top(): Int {
        return stack[stack.lastIndex]
    }

    fun getMin(): Int {
        return min
    }

}