package programs

fun main(){
    val startTime1 = System.currentTimeMillis()
    twoSum3(intArrayOf(2, 80, 5, 8), 88).printResult()  //1,3
    twoSum3(intArrayOf(12, 47, 50, 41, 10), 51).printResult()  //3,4
    twoSum3(intArrayOf(10, 15, 50, 2, -5, 70, -10), 45).printResult() //2,4
    twoSum3(intArrayOf(15,-15,2,0,5), -10).printResult() //1,4
    twoSum3(intArrayOf(2,80,0,5,-10), -10).printResult() //2,4
    twoSum3(intArrayOf(2,7,11,15), 9).printResult() //0,1
    twoSum3(intArrayOf(3,2,4), 6).printResult() //1,2
    twoSum3(intArrayOf(3,3), 6).printResult() //0,1
    val startTime2 = System.currentTimeMillis()
    println("Total Time : ${startTime2-startTime1}")
}

fun twoSum3(nums: IntArray, target: Int): IntArray{

    val map = HashMap<Int,Int>()

    nums.forEachIndexed { index, value ->

        val firstValueIndex = map[value]
        firstValueIndex?.let {
            return intArrayOf(firstValueIndex,index)
        }

        map[target-value] = index
    }

    return intArrayOf()
}