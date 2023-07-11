package programs

fun main(){

   secondLarge()

}

fun matchingChar(){
    val s1 = "abcd"
    val s2 = "abde"

    var output = 0

    s1.forEach { char ->

        s2.forEach { charInS2  ->
            if(char == charInS2)
                output+=1
        }
    }

    println(output)
}

fun secondLarge(){

    val list = listOf(56, 41, 19, 33, 13, 23, 25, 56)

    var maxVal = Integer.MIN_VALUE

    list.forEach {
        if(it > maxVal)
            maxVal = it
    }

    var secondMax = Integer.MIN_VALUE

    list.forEach {
         if((it > secondMax) && (it != maxVal))
             secondMax = it
    }

    println(secondMax)
}