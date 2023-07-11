package programs

fun main() {
    println("Length of Longest Substring : ${lengthOfLongestSubstring2("abcabcbb")}")
    println("Length of Longest Substring : ${lengthOfLongestSubstring2("bbbbb")}")
    println("Length of Longest Substring : ${lengthOfLongestSubstring2("pwwkew")}")
    println("Length of Longest Substring : ${lengthOfLongestSubstring2(" ")}")
    println("Length of Longest Substring : ${lengthOfLongestSubstring2("dvdf")}")
}

fun lengthOfLongestSubstring2(s: String): Int {

    var lengthOfLongestSubstring = 0
    val charMap = HashMap<Char,Int>()

    var left = 0
    var right = 0

    while(right < s.length){

        val char = s[right]

        //Char already exist in the map
        if(charMap[char] != null && charMap[char]!! >= left){
            lengthOfLongestSubstring = if(lengthOfLongestSubstring > right-left) lengthOfLongestSubstring else right-left
            left =  charMap[char]!! + 1

        }

        charMap[char] = right
        right++
    }


    return if(lengthOfLongestSubstring > right-left) lengthOfLongestSubstring else right-left
}



