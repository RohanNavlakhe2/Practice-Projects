package learning.learn.inheritance

import learning.learn.dataTypes

var halfPart = 0
var remains = 0


fun main() {
    var fstChild = Child("Rohan", 24, 10000000)
    fstChild.property()
    fstChild.home(4000000)
    fstChild.car(1000000)


    var sndChild = Child("Saurabh", 29, 10000000)
    sndChild.property()
    sndChild.mobile(25000)
    sndChild.bike(100000)
    println(sndChild)


}


open class Parent(var name: String, var age: Int, var totalAccets: Int) {

    fun property() {
        halfPart = totalAccets / 2
        if (age >= 18) {
            println("[$name is $age year old & his part is $halfPart half of $totalAccets.]")
        } else {
            println("[$name's age is not allowed now to get his part is $halfPart.]")
        }
    }


}


class Child(name: String, age: Int, totalAccets: Int) : Parent(name, age, totalAccets) {
    var add = "Lakheradi"

    fun home(expense: Int) {
        remains = halfPart - expense
        println("I bought A Home at $expense Rs.")
        println("Now in my Account $remains Rs.")
    }

    fun car(expense: Int) {
        remains -= expense
        println("I bought a car at $expense Rs.")
        println("My Total Account Balance is $remains Rs.")
        println("=============================")
    }


    fun mobile(expense: Int) {
        remains = halfPart - expense
        println("I bought A Mobile at $expense Rs.")
        println("Now in my Account $remains Rs.")
    }

    fun bike(expense: Int) {
        remains -= expense
        println("I bought A Bike at $expense Rs.")
        println("My Total Account Balance is $remains Rs.")
        println("=============================")
    }


}




