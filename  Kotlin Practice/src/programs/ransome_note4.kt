package programs

fun main(){
   println("Can Construct a from b : ${canConstruct4("a","b")}")
   println("Can Construct aa from ab : ${canConstruct4("aa","ab")}")
   println("Can Construct aa from aab : ${canConstruct4("aa","aab")}")

}

fun canConstruct4(ransomNote: String, magazine: String): Boolean {

    if(ransomNote.length > magazine.length)
        return false

    val ransomNoteEachCharacterCount = countEachCharacterOccurance4(ransomNote)
    val magazineEachCharacterCount =  countCharacterOccuranceForMagazine(magazine, ransomNote)

    ransomNote.forEach { char ->

        if(ransomNoteEachCharacterCount[char]!! > (magazineEachCharacterCount[char] ?: 0))
            return false
    }

    return true
}

fun countEachCharacterOccurance4(string:String):Map<Char,Int>{
    val map = HashMap<Char,Int>()

    string.forEach {char->
        val value = map[char] ?: 0
        map[char] = value + 1
    }

    return map
}

fun countCharacterOccuranceForMagazine(magazine: String,ransomNote: String):Map<Char,Int>{

    val map = HashMap<Char,Int>()

    magazine.forEach { char ->
        if(ransomNote.contains(char)){
            val value = map[char] ?: 0
            map[char] = value + 1
        }
    }

    return map
}