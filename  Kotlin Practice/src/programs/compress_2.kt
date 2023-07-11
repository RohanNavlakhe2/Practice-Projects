package programs

fun main() {
  println(compress2(charArrayOf('a','a','b','b','c','c','c')))
  println(compress2(charArrayOf('a')))
  println(compress2(charArrayOf('a','b','b','b','b','b','b','b','b','b','b','b','b')))
}

fun compress2(chars: CharArray): Int {

    if(chars.size == 1){
        return 1
    }

    var char = chars[0]
    var charCount = 1
    var backward = 0

    for(i in 1..chars.lastIndex){
        if(chars[i] == char){
            charCount++

            if(i == chars.lastIndex){
                chars[backward] = char
                backward++
                if(charCount > 1){
                    charCount.toString().forEach {countChar ->
                        chars[backward] = countChar
                        backward++
                    }
                }
            }
        }else{
            chars[backward] = char
            backward++
            if(charCount > 1){
                charCount.toString().forEach {countChar ->
                    chars[backward] = countChar
                    backward++
                }
            }

            if(i == chars.lastIndex && chars[i] != char){
                chars[backward] = chars[i]
                backward++
            }

            char = chars[i]
            charCount = 1
        }
    }

    /*for(backwardIndex in backward..chars.lastIndex){
        chars[backwardIndex] = ' '
    }*/

    println("Chars : ${chars.contentToString()}")
    return backward
}