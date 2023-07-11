package programs

fun main() {
    val startTime1 = System.currentTimeMillis()
    twoSum(intArrayOf(2, 80, 5, 8), 88).printResult()  //1,3
    twoSum(intArrayOf(12, 47, 50, 41, 10), 51).printResult()  //3,4
    twoSum(intArrayOf(10, 15, 50, 2, -5, 70, -10), 45).printResult() //2,4
    twoSum(intArrayOf(15,-15,2,0,5), -10).printResult() //1,4
    twoSum(intArrayOf(2,80,0,5,-10), -10).printResult() //2,4
    twoSum(intArrayOf(2,7,11,15), 9).printResult() //0,1
    twoSum(intArrayOf(3,2,4), 6).printResult() //1,2
    twoSum(intArrayOf(3,3), 6).printResult() //0,1
    val startTime2 = System.currentTimeMillis()
    println("Total Time : ${startTime2-startTime1}")
}

fun IntArray.printResult() {
    forEach {
        print("$it ")
    }

    println()
}

fun twoSum(nums: IntArray, target: Int): IntArray {

    val numbersSmallerThanTarget = HashMap<Int, Int>()
    val numbersBiggerThanTarget = HashMap<Int, Int>()
    val numbersSmallerOrBiggerThan0 = HashMap<Int, Int>()

    val isTargetPositive = target >= 0

    nums.forEachIndexed { index, number ->

        when {

            if(isTargetPositive) number in 0..target else number < target -> {
                numbersSmallerThanTarget[index] = number
            }

            if(isTargetPositive) number > target else number in 0 downTo target -> {
                numbersBiggerThanTarget[index] = number
            }

            else -> {
                numbersSmallerOrBiggerThan0[index] = number
            }

        }
    }

    if(isTargetPositive){
        val res1 = performInMapTargetSearch(numbersSmallerThanTarget,target)
        if(res1 != null)
            return res1

        return performCrossMapTargetSearch(numbersBiggerThanTarget,numbersSmallerOrBiggerThan0,target)!!
    }else{
        val res1 = performInMapTargetSearch(numbersBiggerThanTarget,target)
        if(res1 != null)
            return res1

        return performCrossMapTargetSearch(numbersSmallerThanTarget,numbersSmallerOrBiggerThan0,target)!!
    }
}

fun performInMapTargetSearch(map:HashMap<Int,Int>,target: Int):IntArray?{
    val mapKeys = map.keys.toList()

    for (i in mapKeys.indices) {
        val currentValue = map[mapKeys[i]]
        for (j in (i + 1) until mapKeys.size) {
            val nextValue = map[mapKeys[j]]
            if (target - currentValue!! == nextValue)
                return intArrayOf(mapKeys[i],mapKeys[j])
        }
    }

    return null
}

fun performCrossMapTargetSearch(outerMap:HashMap<Int,Int>,innerMap:HashMap<Int,Int>,target: Int):IntArray?{
    outerMap.forEach { entry ->
        innerMap.forEach { entry2 ->
            if (entry.value + entry2.value == target)
                return intArrayOf(entry.key, entry2.key)
        }
    }

    return null
}
