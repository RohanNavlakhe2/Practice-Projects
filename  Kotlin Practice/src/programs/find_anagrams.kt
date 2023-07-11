package programs

fun main() {
  println(findAnagrams("abc","acb"))
}

fun findAnagrams(s: String, p: String): List<Int> {

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

    while (right < s.length) {

        if (left == 0) {

            while (right < (left + p.length)) {

                if((left + p.length) > s.length){
                    return emptyList()
                }

                val currentChar = s[right]
                val charCountInStringP = anagramSubstringRequiredCharMap[currentChar] ?: pCountMap[currentChar]

                if (charCountInStringP == null) {
                    //means current char from string s is not present in string p
                    left = right + 1
                    right = left
                } else {

                    val requiredCount = charCountInStringP - 1
                    anagramSubstringRequiredCharMap[currentChar] = requiredCount
                    if(requiredCount != 0){
                        unmatchedCharsList.add(currentChar)
                    }else if(unmatchedCharsList.contains(currentChar)){
                        unmatchedCharsList.remove(currentChar)
                    }

                    right++
                }
            }

            if(unmatchedCharsList.isEmpty()){
                resultList.add(left)
            }

        }else{
            val previousWindowChar = s[left-1]
            val previousWindowCharCountInRequiredChar = anagramSubstringRequiredCharMap[previousWindowChar] ?: 0

            if(previousWindowCharCountInRequiredChar == 0){
                anagramSubstringRequiredCharMap.remove(previousWindowChar)
                unmatchedCharsList.remove(previousWindowChar)
            }else{
                anagramSubstringRequiredCharMap[previousWindowChar] = previousWindowCharCountInRequiredChar + 1
            }



        }





        left++
        right++
    }

    return resultList
}
