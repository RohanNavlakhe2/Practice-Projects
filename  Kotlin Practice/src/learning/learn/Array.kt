package learning.learn

fun main() {
    //arrayTest()
//    arrayTest2()
    arrayAndLoopPractice()
}

fun arrayTest2(){

    val array:Array<String> = Array(5){ index ->
        if(index == 0)
            return@Array "Kotlin"
        else
            return@Array "#$index"
    }
    println(array.toList())
    array[4] = "kotlin"
    println(array.toList())

    val array2 = IntArray(5)
    println(array2.toList())
    array2[1] = 50
    println(array2.toList())

    val array3 = CharArray(5)
    println(array3.toList())
    array3[1] = 'R'
    println(array3.toList())

    val array4 = FloatArray(5)
    println(array4.toList())
    array4[1] = 18.0f
    println(array4.toList())

    val array5 = DoubleArray(5)
    println(array5.toList())
    array5[1] = 19.0
    println(array5.toList())

    val array6 = BooleanArray(5)
    println(array6.toList())
    array6[1] = "Rohan" == "Saurabh"
    println(array6.toList())
}


fun arrayTest() {
    println(arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday").toList())

    var daysArray: Array<String> = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    println(daysArray.toList())

    val userInput = 5
    println(daysArray[userInput - 1])

    daysArray[4] = "Fri"
    println(daysArray[4])

    println(daysArray.size)

    println(daysArray.indexOf("Sunday"))

    daysArray = daysArray.plus("abc")
    println(daysArray.size)

    var booleanArray: Array<Boolean> = arrayOf(0==0,"Rohan"=="Saurabh")
    println(booleanArray.toList())
    println(booleanArray.size)

    println(arrayOf("0==0 - " , 0==0,"Rohan==Saurabh - ", "Rohan"=="Saurabh").toList())

    sortArray()

    reverseArray(daysArray)

    maxAndMinArray()
}


fun reverseArray(array: Array<String>) {
    val reversedArray = array.reversedArray()
    println("Reversed Array")
    printArray(reversedArray as Array<Any>)
}

fun sortArray() {
    val numArray = intArrayOf(5, 41, 20, 48, 140, 100)
    val sortedArrayAscending = numArray.sortedArray()
    println("Sorted Ascending")
    printArray(sortedArrayAscending.toTypedArray() as Array<Any>)
    println(numArray)

    val sortedArrayDescending = numArray.sortedArrayDescending()
    println("Sorted Descending")
    printArray(sortedArrayDescending.toTypedArray() as Array<Any>)
}

fun maxAndMinArray() {
    val numArray = floatArrayOf(25.5f, 5.7f, 0.5f, 147.4f)
    val minValue = numArray.min()
    println("Min Value : $minValue")

    val maxValue = numArray.max()
    println("Max Value : $maxValue")
}

fun arrayAndLoopPractice() {
    var namesArray = arrayOf("(R) = Rohan", "(S) = Saurabh", "(D) = Dipika", "(V) = Vijay")
    for ((sn, names) in namesArray.withIndex()) {
        println("$sn - $names")

    }
    println(namesArray.toList())

    namesArray.withIndex().forEach {
        println("${it.index} - ${it.value}")
    }

    namesArray.withIndex().forEach {
        print("${it.index} - ${it.value} | ")
    }


}


fun printArray(array: Array<Any>) {
    array.forEach {
        println(it)
    }
}

//fun printArray(array:IntArray){
//    array.forEach {i ->
//        println(i)
//    }
//}