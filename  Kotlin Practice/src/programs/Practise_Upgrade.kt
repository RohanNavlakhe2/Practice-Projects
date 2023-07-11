package programs

fun main() {
    cricket()
}


fun cricket() {

    println("Input Team Name")
    val team = readLine()!!
    println("$team = 0-0 (0)")
    getScoreToUmpire(team)
}


fun getScoreToUmpire(team: String) {
    var runs = readLine()!!.toInt()
    var wickets = readLine()!!.toInt()
    var overs = readLine()!!.toFloat()

    when (!(runs < 0 || wickets < 0 || overs < 0)) {
        true -> score(team, runs, wickets, overs)
    }

}


fun score(team: String, runs: Int, wickets: Int, overs: Float) {

    when (wickets <= 10 && (overs <= overs.toInt() + 0.5 && overs <= 20f)) {
        true -> {
            println("$team = $runs-$wickets ($overs)")
            var oppositeTeam = ""
            oppositeTeam = when (team) {
                "IND" -> "ENG"
                else -> "IND"
            }
            when (wickets == 10 || overs == 20f) {
                true -> {
                    target = (runs + 1)
                    println("$oppositeTeam need $target runs to win")
                    println("$oppositeTeam = 0-0 (0)")
                    getScoreToUmpireAgain(oppositeTeam)
                }
                else -> {
                    getScoreToUmpire(team)
                }

            }
        }
        else -> {
            getScoreToUmpire(team)
        }
    }


}


fun getScoreToUmpireAgain(oppositeTeam: String) {
    var runs = readLine()!!.toInt()
    var wickets = readLine()!!.toInt()
    var overs = readLine()!!.toFloat()
    scoreAgain(oppositeTeam, runs, wickets, overs)
}


fun scoreAgain(oppositeTeam: String, runs: Int, wickets: Int, overs: Float) {
    when (wickets <= 10 && (overs <= overs.toInt() + 0.5 && overs <= 20f)) {
        true -> {
            when (!(runs >= target && wickets == 10)) {
                true -> println("$oppositeTeam = $runs-$wickets ($overs)")
            }

            var left = 10 - wickets
            var rest = (target - 1) - runs

            when (runs >= target && (wickets != 10)) {
                true -> {
                    println("$oppositeTeam won the match by $left Wickets")
                }
                else -> {
                    when (runs == (target - 1) && (wickets == 10 || overs == 20f)) {
                        true -> {
                            println("Match Tie")
                        }
                        else -> {
                            when (runs < (target - 1) && (wickets == 10 || overs == 20f)) {
                                true -> {
                                    println("$oppositeTeam Lost the match by $rest Runs")
                                }
                                else -> {
                                    getScoreToUmpireAgain(oppositeTeam)
                                }
                            }
                        }
                    }
                }
            }
        }
        else -> {
            getScoreToUmpireAgain(oppositeTeam)
        }
    }
}