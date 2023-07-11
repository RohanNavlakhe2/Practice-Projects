package programs

fun main(){
    println(isPalindrome( "race a car"))

}

fun isPalindrome(s: String): Boolean {
    var str = ""
    s.forEach {
        if(it.isLetterOrDigit()){
            str += it
        }
    }

    for (i in 0 until str.length/2){
         if(!str[i].equals(str[str.lastIndex-i],true)){
             return false
         }
    }

    return true

}