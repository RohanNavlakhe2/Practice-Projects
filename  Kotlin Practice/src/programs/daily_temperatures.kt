package programs

import java.util.*

fun main(){
    println(dailyTemperatures(intArrayOf(73,74,75,71,69,72,76,73)).contentToString())
    println(dailyTemperatures(intArrayOf(30,40,50,60)).contentToString())
    println(dailyTemperatures(intArrayOf(30,60,90)).contentToString())
}

fun dailyTemperatures(temperatures: IntArray): IntArray {

    val answer = IntArray(temperatures.size)
    val stack = ArrayDeque<Int>()

    temperatures.forEachIndexed { index, num ->
        if(stack.isEmpty()){
            stack.push(index)
        }else{
            while(stack.peek() != null && temperatures[stack.peek()] < num){
                val currentStackValue = stack.pop()
                answer[currentStackValue] = index - currentStackValue
            }
            stack.push(index)
        }
    }

    return answer
}