package programs

fun main() {
  println(findAnagrams2("abccbabca","bca"))
  println(findAnagrams2("cbaebabacd","abc"))
  println(findAnagrams2("abab","ab"))
  println(findAnagrams2("abaacbabc","abc"))
}

fun findAnagrams2(s: String, p: String): List<Int> {

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

        right++
    }

    return resultList
}
