package programs

fun main() {

}

fun isSubsequence(s: String, t: String): Boolean {

    if (s.isEmpty)
        return true
    if (t.isEmpty)
        return false

    var searchFor = 0

    t.forEach { char ->
        val searchForChar = s[searchFor]
        if(char == searchForChar){
            searchFor++
            if(searchFor == s.length)
                return true
        }
    }

    return false
    
}