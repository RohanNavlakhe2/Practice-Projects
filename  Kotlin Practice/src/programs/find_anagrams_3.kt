package programs

fun main() {
  /*println(findAnagrams3("abccbabca","bca"))
  println(findAnagrams3("cbaebabacd","abc"))
  println(findAnagrams3("abab","ab"))
  println(findAnagrams3("abaacbabc","abc"))*/
  println(findAnagrams3("ababababab","aab"))
}

fun findAnagrams3(s: String, p: String): List<Int> {

    val resultList = mutableListOf<Int>()

    val pCountMap = HashMap<Char, Int>()
    for (char in p) {
        val charCount = pCountMap[char] ?: 0
        pCountMap[char] = charCount + 1
    }

    val anagramSubstringRequiredCharMap = HashMap<Char, Int>()

    var left = 0
    var right = 0

    val unmatchedCharsList = mutableSetOf<Char>()

    while (right < s.length && s.length - left >= p.length) {

        println("-------------------------------------------")
        println("Left : $left   Right : $right  Map : $anagramSubstringRequiredCharMap")
        println("Unmatched List : $unmatchedCharsList")
        println("-------------")

        val currentChar = s[right]
        val currentCharCountInP = pCountMap[currentChar]

        if (currentCharCountInP == null) {
            left = right + 1
            right = left
            anagramSubstringRequiredCharMap.clear()
            unmatchedCharsList.clear()
            continue
        }else{

            val currentCharCountInRequiredCharMap = anagramSubstringRequiredCharMap[currentChar] ?: currentCharCountInP
            val requiredCount = currentCharCountInRequiredCharMap - 1
            anagramSubstringRequiredCharMap[currentChar] = requiredCount

            if(requiredCount != 0){
                unmatchedCharsList.add(currentChar)
            }else if(unmatchedCharsList.contains(currentChar)){
                unmatchedCharsList.remove(currentChar)
            }

        }

        if(right-left == p.length-1){
            //check if unmatched list is empty, if yes add the left to resultList
            if(unmatchedCharsList.isEmpty()){
                resultList.add(left)
            }

            left++

            val previousWindowChar = s[left-1]
            val previousWindowCharCountInRequiredChar = anagramSubstringRequiredCharMap[previousWindowChar] ?: 0

            if(previousWindowCharCountInRequiredChar == 0){
                anagramSubstringRequiredCharMap.remove(previousWindowChar)
                unmatchedCharsList.remove(previousWindowChar)
            }else{
                val newCount =  previousWindowCharCountInRequiredChar + 1
                anagramSubstringRequiredCharMap[previousWindowChar] = newCount
                if(newCount == 0){
                    //anagramSubstringRequiredCharMap.remove(previousWindowChar)
                    unmatchedCharsList.remove(previousWindowChar)
                }
            }
        }

        println("Left : $left Right : $right Map : $anagramSubstringRequiredCharMap")
        println("Unmatched List : $unmatchedCharsList")
        println("-------------------------------------------")

        right++
    }

    return resultList
}
