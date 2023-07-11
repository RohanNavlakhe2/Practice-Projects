package learning.learn



fun getData(): String {
    return "rohan"
}

fun getData2(): String {
    return "mvlem!25g----65/*6"
}

fun plus() {
    println("Please Enter First number")
    val firstNum = readLine()!!.toInt()
    println("Please Enter Second number")
    val secondNum = readLine()!!.toInt()
    add(firstNum, secondNum)
}

fun minus() {
    var num1 = 20
    var num2 = 10
    var num = num1 - num2
    println("$num1-$num2=$num}")
    dataTypes()
}


fun multiply() {
    var m = 100
    m = 80
    m = m
    println("$m")

}

fun square(input: Int, input1: Int) {
    val result = input * input
    println("Square of $input is $result")
    val result1 = input1 * input1
    println("Square of $input1 is $result1")
}

fun add(num1: Int, num2: Int) {
    val result = num1 + num2
    println("Addition of $num1 and $num2 is $result")
    square(num1, num2)
}