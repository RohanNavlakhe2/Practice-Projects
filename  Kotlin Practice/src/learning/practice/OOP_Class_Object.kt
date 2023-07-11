package learning.practice


var playing11List = mutableListOf<Team>()

fun main() {

    println("1. Add Players")

    while (true){

        println("2. Provide Player Score")
        println("3. Print All Player Details")

        val input = readLine()!!.toInt()

        when(input){
            1 -> {
                input()
            }

            2-> playerScore()
            3 -> outputScr()
        }
    }


}


fun input() {

    println("**Create Your Own \"Playing_11\"**")

    for (i in 1..2) {

        println("**\"Player's Name\"**")
        var name = readLine()!!

        println("**\"Country's Name\"**")
        var country = readLine()!!

        println("**\"Type of Playing\"**")
        var type = readLine()!!

        var player = Team(name, country, type)

        playing11List.add(player)


    }
    println(playing11List)
}

fun playerScore() {

    playing11List.forEachIndexed {index, player ->
        println("$index ${player.name}")
    }

    println("Enter Player No")
    val scoreOfPlayer = readLine()!!.toInt()
    val player = playing11List[scoreOfPlayer]

    println("Input Ball No and Runs")
    val ball = readLine()!!.toInt()
    val runs = readLine()!!.toInt()

    player.scoreMap[ball] = runs

}

fun outputScr() {

    playing11List.forEach { player ->
        println(player)
        println("Balls : Runs")

        player.scoreMap.forEach {
            println("${it.key} : ${it.value}")
        }

        player.info()
    }


}


data class Team(var name: String, var country: String, var type: String) {

    var scoreMap = mutableMapOf<Int, Int>()

    fun info() {
        var totalBalls = scoreMap.keys.sum().toFloat()
        var totalRuns = scoreMap.values.sum().toFloat()
        var strikeRate = (totalRuns * 100) / totalBalls
        println("Balls : $totalBalls")
        println("Runs : $totalRuns")
        println("Strike Rate : $strikeRate")

    }

}
