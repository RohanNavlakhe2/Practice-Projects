package programs

fun main() {
    println("Length of Longest Substring : ${lengthOfLongestSubstring("abcabcbb")}")
    println("Length of Longest Substring : ${lengthOfLongestSubstring("bbbbb")}")
    println("Length of Longest Substring : ${lengthOfLongestSubstring("pwwkew")}")
    println("Length of Longest Substring : ${lengthOfLongestSubstring(" ")}")
    println("Length of Longest Substring : ${lengthOfLongestSubstring("dvdf")}")
}

fun lengthOfLongestSubstring(s: String): Int {

    val charactersAndTheirPostionsMap = HashMap<Char, Int>()
    var avoidCharsInMapBeforeIndex = -1
    var currentSubstringCount = 0
    var longestSubstringCount = 0

    s.forEachIndexed { index, char ->

        val currentCharIndexInMap = charactersAndTheirPostionsMap[char] ?: -1
        val doesCharAlreadyExistInMap =
            currentCharIndexInMap != -1 && currentCharIndexInMap > avoidCharsInMapBeforeIndex

        if (doesCharAlreadyExistInMap) {

            if (currentSubstringCount > longestSubstringCount)
                longestSubstringCount = currentSubstringCount

            currentSubstringCount = (index - currentCharIndexInMap) - 1
            avoidCharsInMapBeforeIndex = currentCharIndexInMap
        }

        charactersAndTheirPostionsMap[char] = index
        currentSubstringCount += 1
    }

    if (currentSubstringCount > longestSubstringCount)
        longestSubstringCount = currentSubstringCount

    return longestSubstringCount

}


