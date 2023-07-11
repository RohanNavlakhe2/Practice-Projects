package programs

fun main(){
   println("Can Construct a from b : ${canConstruct3("a","b")}")
   println("Can Construct aa from ab : ${canConstruct3("aa","ab")}")
   println("Can Construct aa from aab : ${canConstruct3("aa","aab")}")

}

fun canConstruct3(ransomNote: String, magazine: String): Boolean {

    if(ransomNote.length > magazine.length)
        return false

    val ransomNoteEachCharacterCount = countEachCharacterOccurance(ransomNote)
    val magazineEachCharacterCount = countEachCharacterOccurance(magazine)

    ransomNote.forEach { char ->

        if(ransomNoteEachCharacterCount[char]!! > (magazineEachCharacterCount[char] ?: 0))
            return false
    }

    return true
}

fun countEachCharacterOccurance(string:String):Map<Char,Int>{
    val map = HashMap<Char,Int>()

    string.forEach {char->
        val value = map[char] ?: 0
        map[char] = value + 1
    }

    return map
}