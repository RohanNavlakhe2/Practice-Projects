package programs

fun main(){
   println("Can Construct a from b : ${canConstruct2("a","b")}")
   println("Can Construct aa from ab : ${canConstruct2("aa","ab")}")
   println("Can Construct aa from aab : ${canConstruct2("aa","aab")}")

}

fun canConstruct2(ransomNote: String, magazine: String): Boolean {

    if(ransomNote.length > magazine.length)
        return false

    var magazine = magazine

    ransomNote.forEach { char ->

        if(!magazine.contains(char))
            return false

        magazine = magazine.replaceFirst(char.toString(),"")
    }

    return true
}