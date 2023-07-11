package programs

import kotlin.math.abs

fun main(){
  println(intToRoman2(10))
}

fun intToRoman2(num: Int): String {

    val numStr = num.toString()
    var multiplyWith:Int
    var resultStr = StringBuilder()

    multiplyWith = when(numStr.length){
        1 -> 1
        2 -> 10
        3 -> 100
        4 -> 1000
        else -> 1
    }

    loop@ for(i in numStr.lastIndex downTo 0){

        var currentNum = numStr[i].toInt()

        when(i){

            numStr.lastIndex -> {
                //Current num is ekai

                if(currentNum == 0)
                    continue@loop

                val differenceFrom5 = currentNum - 5
                if(differenceFrom5 == 4){
                    //means the number is 9
                    resultStr.append("IX")
                    continue@loop
                }else if(differenceFrom5 == -1){
                    //means the number is 4
                    resultStr.append("IV")
                    continue@loop
                }else if(currentNum >= 5){
                    resultStr.append("V")
                }

                for(j in 1..abs(differenceFrom5)){
                    resultStr.append("I")
                }

            }

            numStr.lastIndex - 1 -> {
                //current num is dahai

                if(currentNum == 0)
                    continue@loop

                currentNum *= 10
                val differenceFrom50 = currentNum - 50

                if(differenceFrom50 == 40){
                    //means the number is 90
                    resultStr.append("XC")
                    continue@loop
                }else if(differenceFrom50 == -10){
                    //means the number is 40
                    resultStr.append("XL")
                    continue@loop
                }else if(currentNum >= 50){
                    resultStr.append("L")
                }

                for(j in 10..abs(differenceFrom50) step 10){
                    resultStr.append("X")
                }
            }

            numStr.lastIndex - 2 -> {
                //current num is sekda
            }

            numStr.lastIndex - 3 -> {
                //current num is hajar
            }


        }
    }

   return resultStr.reverse().toString()
}