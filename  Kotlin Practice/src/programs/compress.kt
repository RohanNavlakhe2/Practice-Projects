package programs

fun main() {
  println(compress(charArrayOf('a','a','b','b','c','c','c')))
  println(compress(charArrayOf('a')))
  println(compress(charArrayOf('a','b','b','b','b','b','b','b','b','b','b','b','b')))
}

fun compress(chars: CharArray): Int {

    if(chars.size == 1){
        return 1
    }

    val s = StringBuilder()
    var char = chars[0]
    var charCount = 1

    for(i in 1..chars.lastIndex){
        if(chars[i] == char){
            charCount++

            if(i == chars.lastIndex){
                s.append(char)
                if(charCount > 1){
                    s.append(charCount.toString())
                }
            }
        }else{
            s.append(char)
            if(charCount > 1){
                s.append(charCount.toString())
            }

            if(i == chars.lastIndex && chars[i] != char){
                s.append(chars[i])
            }

            char = chars[i]
            charCount = 1
        }
    }

    for(i in chars.indices){
       if(i > s.lastIndex){
           chars[i] = ' '
       }else{
           chars[i] = s[i]
       }
    }

    println("Chars : ${chars.contentToString()}")
    return s.length
}