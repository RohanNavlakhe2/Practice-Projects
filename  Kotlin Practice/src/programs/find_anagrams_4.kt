package programs

fun main() {
  println(findAnagrams4("abccbabca","bca"))
  println(findAnagrams4("cbaebabacd","abc"))
  println(findAnagrams4("abab","ab"))
  println(findAnagrams4("abaacbabc","abc"))
  println(findAnagrams4("ababababab","aab"))
  println(findAnagrams4("vwwvv","vwv"))
}

fun findAnagrams4(s: String, p: String): List<Int> {

    val resultList = mutableListOf<Int>()

    val pCountMap = HashMap<Char, Int>()
    for (char in p) {
        val charCount = pCountMap[char] ?: 0
        pCountMap[char] = charCount + 1
    }

    val anagramSubstringAvailableCharMap = HashMap<Char, Int>()

    var left = 0
    var right = 0

    val unmatchedCharsList = mutableSetOf<Char>()

    while (right < s.length && s.length - left >= p.length) {

        /*println("-------------------------------------------")
        println("Left : $left   Right : $right  Map : $anagramSubstringAvailableCharMap")
        println("Unmatched List : $unmatchedCharsList")
        println("-------------")*/

        val currentChar = s[right]
        val actualCharCountInP = pCountMap[currentChar]

        if (actualCharCountInP == null) {
            left = right + 1
            right = left
            anagramSubstringAvailableCharMap.clear()
            unmatchedCharsList.clear()
            continue
        }else{

            val availableCharCount = (anagramSubstringAvailableCharMap[currentChar] ?: 0) + 1
            val requiredCount = actualCharCountInP - availableCharCount
            anagramSubstringAvailableCharMap[currentChar] = availableCharCount


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
            val previousWindowCharActualCountInP = pCountMap[previousWindowChar]
            val previousWindowCharCountInAvailableCharMap = anagramSubstringAvailableCharMap[previousWindowChar]
            if(previousWindowCharCountInAvailableCharMap != null){
                anagramSubstringAvailableCharMap[previousWindowChar] = previousWindowCharCountInAvailableCharMap - 1
            }

            if(unmatchedCharsList.contains(previousWindowChar) &&
                previousWindowCharActualCountInP == anagramSubstringAvailableCharMap[previousWindowChar]){
                unmatchedCharsList.remove(previousWindowChar)
            }

        }

       /* println("Left : $left Right : $right Map : $anagramSubstringAvailableCharMap")
        println("Unmatched List : $unmatchedCharsList")
        println("-------------------------------------------")*/

        right++
    }

    return resultList
}
