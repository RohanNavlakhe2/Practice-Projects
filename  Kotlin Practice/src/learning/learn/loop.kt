package learning.learn

fun forLoop() {

    for (num in 1..10) {
        println(num) //1-10
    }

    for (num in 1 until 10) {
        println(num) //1-9
    }

    for (num in 10 downTo 1) {
        println(num) //10-1
    }

    for (num in 1..10 step 2) {
        println(num)
    }

    for (char in "Rohan") {
        println(char)
    }

}