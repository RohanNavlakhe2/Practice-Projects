package programs

fun main() {
    println(intToRoman(10))
    println(intToRoman(4))
    println(intToRoman(66))
    println(intToRoman(3699))
    println(intToRoman(520))
    println(intToRoman(58))

}

fun intToRoman(num: Int): String {

    val numStr = num.toString()
    var multiplyWith = 1
    var resultStr = ""
    val romans = arrayOf("I", "V", "X")


    loop@ for (i in numStr.lastIndex downTo 0) {

        var currentNum = numStr[i].toString().toInt() * multiplyWith

        when (multiplyWith) {
            10 -> {
                romans[0] = "X"
                romans[1] = "L"
                romans[2] = "C"
            }

            100 -> {
                romans[0] = "C"
                romans[1] = "D"
                romans[2] = "M"
            }

            1000 -> {
                romans[0] = "M"
                romans[1] = "0"
                romans[2] = "0"
            }
        }

        var temp = ""

        if (currentNum == 9 * multiplyWith) {
            resultStr = "${romans[0]}${romans[2]}$resultStr"
            multiplyWith *= 10
            continue@loop
        } else if (currentNum == 4 * multiplyWith) {
            resultStr = "${romans[0]}${romans[1]}$resultStr"
            multiplyWith *= 10
            continue@loop
        } else if (currentNum >= 5 * multiplyWith) {
            temp = romans[1]
            currentNum -= 5 * multiplyWith

        }

        for (j in 1 * multiplyWith..currentNum step 1 * multiplyWith) {
            temp = "$temp${romans[0]}"
        }

        resultStr = "$temp$resultStr"
        multiplyWith *= 10

    }

    return resultStr
}