package programs

fun main(){
    println(isPalindrome3( ",,,,,,,,,,,,acva"))

}

fun isPalindrome3(s: String): Boolean {

    var i=0
    var j = s.lastIndex

    while(i<j){

        val isILetterOrDigit = s[i].isLetterOrDigit()
        val isJLetterOrDigit = s[j].isLetterOrDigit()

        if(isILetterOrDigit && isJLetterOrDigit){
            if(!s[i].equals(s[j],true)){
                return false
            }
        }

        if(!isILetterOrDigit && !isJLetterOrDigit){
            i++
            j--
            continue
        }

        if(isJLetterOrDigit){
            i++
        }

        if(isILetterOrDigit){
            j--
        }

    }

    return true
}