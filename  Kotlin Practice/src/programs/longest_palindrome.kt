package programs

fun main(){
  //println(longestPalindrome("babad"))   //bab
  //println(longestPalindrome("cbbd"))    //bb

    val s = "cc"
  println(longestPalindrome("cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc").length)    //bb
}

fun longestPalindrome(s: String): String {

    var biggestPalindromeSubstring = ""
    val palindromeSubStringsMap = HashMap<Pair<Int,Int>,Boolean>()
    val charMap = HashMap<Char,ArrayList<Int>>()

   s.forEachIndexed { index, char ->

       var currentCharPositionsList = charMap[char]

       currentCharPositionsList = currentCharPositionsList?.apply { add(index) } ?: ArrayList<Int>().apply { add(index) }
       charMap[char] = currentCharPositionsList

       for(i in 0..currentCharPositionsList.size-2){
          if(index - currentCharPositionsList[i] in 1..2 || palindromeSubStringsMap[Pair(currentCharPositionsList[i]+1,index-1)] == true){
              //Means from i to index is a palindrome substring
              palindromeSubStringsMap[Pair(currentCharPositionsList[i],index)] = true

              if(s.substring(currentCharPositionsList[i]..index).length > biggestPalindromeSubstring.length)
                  biggestPalindromeSubstring = s.substring(currentCharPositionsList[i]..index)
          }
       }
   }

    if(biggestPalindromeSubstring == "")
        biggestPalindromeSubstring = s[0].toString()

    return biggestPalindromeSubstring

}