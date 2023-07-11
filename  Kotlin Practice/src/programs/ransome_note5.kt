package programs

import kotlin.collections.HashMap

fun main(){
   println("Can Construct aab from aacb : ${canConstruct6("aaB","aaCB")}")
   println("Can Construct dc from bcad : ${canConstruct6("dc","bcad")}")
   println("Can Construct rsv from vsr : ${canConstruct6("rsv","vsr")}")
   println("Can Construct gstr from gst : ${canConstruct6("gstr","gst")}")
   println("Can Construct poem from poeeen : ${canConstruct6("poem","poeeen")}")

}

/*fun canConstruct5(ransomNote: String, magazine: String): Boolean {

    if(ransomNote.length > magazine.length)
        return false

    val ransomNoteLastIndex = ransomNote.lastIndex
    val ransomNoteCharCountMap = HashMap<Char,Int>()
    val magazineCharCountMap = HashMap<Char,Int>()

    val charactersNotInRansomNote = HashMap<Char,Int>()
    var totalCharactersNotInMagazine = 0

    magazine.forEachIndexed { index, magazingChar ->

        var currentChar = magazingChar

        if(index <= ransomNoteLastIndex) {
            val ransomNoteChar = ransomNote[index]
            ransomNoteCharCountMap[ransomNoteChar] = (ransomNoteCharCountMap[ransomNoteChar] ?: 0) + 1
            currentChar = ransomNoteChar
        }

        magazineCharCountMap[magazingChar] = (magazineCharCountMap[magazingChar] ?: 0) + 1

        var currentCharCountInRansomStr:Int = ransomNoteCharCountMap[currentChar] ?: 0
        var currentCharCountInMagazineStr:Int = magazineCharCountMap[currentChar] ?: 0

        var currentCharPreviousDiff:Int = charactersNotInRansomNote[currentChar] ?: 0
        var currentCharNewDiff:Int = currentCharCountInMagazineStr - currentCharCountInRansomStr
        charactersNotInRansomNote[currentChar] = currentCharNewDiff

        if(currentCharNewDiff <= 0){
            if(currentCharNewDiff > currentCharPreviousDiff)
                totalCharactersNotInMagazine += (currentCharNewDiff - currentCharPreviousDiff)
            else if(currentCharNewDiff < currentCharPreviousDiff)
                totalCharactersNotInMagazine -=  (currentCharPreviousDiff - currentCharNewDiff)
        }
    }


    println("Ransom : $ransomNoteCharCountMap")
    println("Magazine : $magazineCharCountMap")
    println("Total Char Not in Magazine : $totalCharactersNotInMagazine")
    return totalCharactersNotInMagazine >= 0
}*/


fun canConstruct6(ransomNote: String, magazine: String): Boolean {

    if(ransomNote.length > magazine.length)
        return false

    val ransomNoteLastIndex = ransomNote.lastIndex
    val ransomNoteCharCountMap = HashMap<Char,Int>()
    val magazineCharCountMap = HashMap<Char,Int>()

    val charactersRequiredToFormRansomNoteFromMagazine = HashMap<Char,Int>()
    var totalCharactersNotInMagazine = 0

    magazine.forEachIndexed { index, magazingChar ->

        var currentCharInRansom = ' '
        var currentCharInMagazine = magazingChar

        if(index <= ransomNoteLastIndex) {
            val ransomNoteChar = ransomNote[index]
            ransomNoteCharCountMap[ransomNoteChar] = (ransomNoteCharCountMap[ransomNoteChar] ?: 0) + 1
            currentCharInRansom = ransomNoteChar
        }

        magazineCharCountMap[magazingChar] = (magazineCharCountMap[magazingChar] ?: 0) + 1

        var currentCharInRansomCountInRansomStr:Int = ransomNoteCharCountMap[currentCharInRansom] ?: 0
        var currentCharInRansomCountInMagazineStr:Int = magazineCharCountMap[currentCharInRansom] ?: 0

        var currentCharInMagazineCountInRansomStr:Int = ransomNoteCharCountMap[currentCharInMagazine] ?: 0
        var currentCharInMagazineCountInMagazineStr:Int = magazineCharCountMap[currentCharInMagazine] ?: 0

        if((currentCharInRansom != ' ') && (currentCharInRansomCountInRansomStr >= currentCharInRansomCountInMagazineStr)){
             val currentDiff = currentCharInRansomCountInRansomStr - currentCharInRansomCountInMagazineStr
             val lastDiff = charactersRequiredToFormRansomNoteFromMagazine[currentCharInRansom] ?: 0

            if(lastDiff > currentDiff)
                totalCharactersNotInMagazine -= (lastDiff-currentDiff)
            else if(currentDiff > lastDiff)
                totalCharactersNotInMagazine += currentDiff - lastDiff

            charactersRequiredToFormRansomNoteFromMagazine[currentCharInRansom] = currentDiff

        }

        if(currentCharInMagazineCountInRansomStr >= currentCharInMagazineCountInMagazineStr){

            val currentDiff = currentCharInMagazineCountInRansomStr - currentCharInMagazineCountInMagazineStr
            val lastDiff = charactersRequiredToFormRansomNoteFromMagazine[currentCharInMagazine] ?: 0

            if(lastDiff > currentDiff)
                totalCharactersNotInMagazine -= (lastDiff-currentDiff)
            else if(currentDiff > lastDiff)
                totalCharactersNotInMagazine += currentDiff - lastDiff

            charactersRequiredToFormRansomNoteFromMagazine[currentCharInMagazine] = currentDiff

        }
    }


    println("Ransom : $ransomNoteCharCountMap")
    println("Magazine : $magazineCharCountMap")
    println("Characters Required to form Ransom Note from magazine  : $charactersRequiredToFormRansomNoteFromMagazine")
    println("Total Char Not in Magazine : $totalCharactersNotInMagazine")
    return totalCharactersNotInMagazine == 0
}

