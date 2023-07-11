package programs

import kotlin.math.E

var target = 0

fun main() {
//    val result = evenOrOdd(12)
//    println(result)
    playing11()

}

/*fun getDataFromUser() {
    println("Dear user put the first value you want")
    val one = readLine()!!.toFloat()
    println("Dear user put the second value you want")
    val two = readLine()!!.toFloat()
    println("(Thanks for entering)")

    println("1st value = $one")
    println("2nd value = $two")
    println("(We put both of value`s for square)")
    square1(one, two)
}

fun square1(one: Float, two: Float) {
    val cf = one * one
    val df = two * two

    println("Square of 1st value $one is = $cf")
    println("Square of 2nd value $two is = $df")

    println("(Now put both of square value's for calculating tax)")
    taxCalculate(cf, df)

}

fun taxCalculate(cf: Float, df: Float) {
    val firstNum = cf * 18 / 100
    val secondNum = df * 18 / 100
    println("$cf's 18% is = $firstNum")
    println("$df's 18% is = $secondNum")

    println("(Now we are looking who is less.)")
    var diffAmt = 0f
    if (firstNum < secondNum) {
        println("**first Num is Less = $firstNum<$secondNum**")
        diffAmt = secondNum - firstNum

        println("(So 2ndNum - 1stNum = diffAmt)")
        println("$secondNum - $firstNum = $diffAmt") }
    else if (secondNum < firstNum) {
        println("Second Num is Less = $secondNum<$firstNum")
        diffAmt = firstNum - secondNum
        println("(So 1stNum - 2ndNum = diffAmt)")
        println("$firstNum - $secondNum = $diffAmt") }
    else {
        println("No difference are there, because both are same.")}

    val take1 = difference(cf, firstNum)
    val take2 = difference(df, secondNum)

    if (take1 > take2) {


        println("1st invoice value is greater = $take1>$take2")
    } else if (take2 > take1) {

        println("(2nd invoice value is greater = $take2>$take1)")
    } else {
        println("Both are same")
    }

}

fun difference(tax1: Float, less1: Float): Float {
    val result1 = tax1 - less1
    println("(Base Value - Tax Value = Invoice Value)")
    println("$tax1 - $less1 = $result1")
    return result1
}*/

/*fun cricket(){

    println("Input Team Name")
    val team = readLine()!!
    println("$team = 0-0 (0)")
    getScoreToUmpire(team)
}


fun getScoreToUmpire(team: String) {
    var runs = readLine()!!.toInt()
    var wickets = readLine()!!.toInt()
    var overs = readLine()!!.toFloat()

    if(!(runs<0 || wickets<0 || overs<0))
        score(team, runs, wickets, overs)


}


fun score(team: String, runs: Int, wickets: Int, overs: Float) {
    if (wickets <= 10 && (overs <= overs.toInt() + 0.5 && overs <= 20f)) {
        println("$team = $runs-$wickets ($overs)")
        var oppositeTeam = ""
        if (team == "IND") {
            oppositeTeam = "ENG"
        } else {
            oppositeTeam = "IND"
        }
        if (wickets == 10 || overs == 20f) {
            target = (runs + 1)
            println("$oppositeTeam need $target runs to win")
            println("$oppositeTeam = 0-0 (0)")
            getScoreToUmpireAgain(oppositeTeam)
        } else {
            getScoreToUmpire(team)
        }

    } else {
        getScoreToUmpire(team)
    }
}


fun getScoreToUmpireAgain(oppositeTeam: String) {
    var runs = readLine()!!.toInt()
    var wickets = readLine()!!.toInt()
    var overs = readLine()!!.toFloat()
    scoreAgain(oppositeTeam, runs, wickets, overs)
}


fun scoreAgain(oppositeTeam: String, runs: Int, wickets: Int, overs: Float) {
    if (wickets <= 10 && (overs <= overs.toInt() + 0.5 && overs <= 20f)) {

        if (!(runs >= target && wickets == 10))
            println("$oppositeTeam = $runs-$wickets ($overs)")

        var left = 10 - wickets
        var rest = (target - 1) - runs
        if (runs >= target && (wickets != 10)) {
            println("$oppositeTeam won the match by $left Wickets")
        } else if (runs == (target - 1) && (wickets == 10 || overs == 20f)) {
            println("Match Tie")
        } else if (runs < (target - 1) && (wickets == 10 || overs == 20f)) {
            println("$oppositeTeam Lost the match by $rest Runs")
        } else getScoreToUmpireAgain(oppositeTeam)
    } else {
        getScoreToUmpireAgain(oppositeTeam)
    }


}*/


/*
fun whenTest() {

    println("Press 1 to activate sms service")
    println("Press 2 to deactivate sms service")
    println("Press 3 to know your account balance")
    println("Press 4 to know your credit card limit")
    println("Press 5 to get new cheque book")
    println("Press 6 to file a complaint")
    println("Press 7 to get your statement")
    println("Press 8 to talk to our customer care")


    val userInput = readLine()!!

    val userService = when (userInput) {
        "1" -> "Activated SMS Servises"
        "2" -> "Deactivated SMS Servises"
        "3" -> "Your Account Balance"
        "4" -> "Your Credit Card Limit"
        "5" -> "Your New Cheque Book"
        "6" -> "Your Complaint"
        "7" -> "Your Statement"
        "8" -> "Customer Care"
        else -> "No Thanks"

    }
    println("Pressed by Customer = $userInput ")
    println("Service : $userService")
}

fun whenTest2() {
    println("Give Any Input")
    val input = readLine()!!.toInt()

    val relay = when(input) {
        in 1..9 -> "One = 1"
        in 10..99 -> "Two = 2"
        in 100..999 -> "Three = 3"
        in 1000..9999 -> "Four = 4"
        else -> E

    }
    println("Input Is = $input")
    println("This Input Relay in **$relay** Digit Number")

}
*/


/*fun loopTable() {
    var num = 2
    while(num <= 10) {
        var index = 1
        while (index <= 10) {
            println(num * index)
            index++
        }
        num++
    }
}

fun loopName(){
    var num = 1
    while (num <= 10){
      if (num <= 5) {
          println("Rohan")

      }
      else{
          println("Saurabh")

      }

        num++
    }



}*/

/*
fun forLoopPractice() {

    for (num in 2..10) {
        println("**[Table of >>> $num]**")
        for (index in 1..10) {
            println("$num x $index = ${num * index}")
        }
    }

}

fun forLoopPractice2() {

    for (num in 15..20) {
        println("table of $num")
        var index = 1
        for (table in num..num * 10 step num) {
            println("$num * $index = $table")
            ++index
        }
    }

}
*/


/*
fun forLoopPractice3(){

    for(char in "RSDV"){
        var name = when(char){
            'R' -> "Rohan"
            'S' -> "Saurabh"
            'D' -> "Dipika"
            'V' -> "Vijay"
            else -> ""
        }
        println("$char =  $name")
    }

}
*/

/*fun evenOrOdd(num: Int): String {

    val result = when (num % 2 == 0) {
        true -> "Even"
        else -> "Odd"
    }
    return result

}*/


fun playing11() {
    var teamArray = Array(3) {
        "${readLine()}"
    }

    teamArray.forEach {
        println(it)
    }

   

}



