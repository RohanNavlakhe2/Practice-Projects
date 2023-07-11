package programs

fun main(){
    println(isPalindrome2( ",,,,,,,,,,,,acva"))

}

fun isPalindrome2(s: String): Boolean {

    var i=0
    var j = s.lastIndex

    //while(i < s.length/2 && i<j){
    while(i<j){

        if(s[i].isLetterOrDigit() && s[j].isLetterOrDigit()){
            if(!s[i].equals(s[j],true)){
                return false
            }
        }

        if(!s[i].isLetterOrDigit() && !s[j].isLetterOrDigit()){
            i++
            j--
            continue
        }

        var previousIvalue = i

        if(s[j].isLetterOrDigit()){
            i++
        }

        /*if(i==0 || s[i-1].isLetterOrDigit()){
            j--
        }*/

        /*if(s[if(i==0) i else i-1].isLetterOrDigit()){
            j--
        }*/

        if(s[previousIvalue].isLetterOrDigit()){
            j--
        }


    }

    return true
}