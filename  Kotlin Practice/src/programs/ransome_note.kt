package programs

fun main(){
   println("Can Construct a from b : ${canConstruct("a","b")}")
   println("Can Construct aa from ab : ${canConstruct("aa","ab")}")
   println("Can Construct aa from aab : ${canConstruct("aa","aab")}")

}

fun canConstruct(ransomNote: String, magazine: String): Boolean {

    if(ransomNote.length > magazine.length)
        return false

    var charactersProcessed = ""

    ransomNote.forEach { char ->

        val isCharacterAlreadyProcessed = charactersProcessed.contains(char)

        if(!isCharacterAlreadyProcessed){

            charactersProcessed += char.toString()

            if(!magazine.contains(char))
                return false

            val charCountInRansomNote = ransomNote.count { it == char }
            val charCountInMagazine = magazine.count { it == char }

            if(charCountInRansomNote > charCountInMagazine)
                return false

        }

    }

    return true
}