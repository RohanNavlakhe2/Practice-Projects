package programs

fun main(){
  println(longestPalindrome2("a"))
}

fun longestPalindrome2(s:String):String{

    var longestPalindromeSubstring = ""

    for(i in 0..s.lastIndex){
        //when considering the center i has odd string
        val str1 = findPalindrome(s,i,i)
        //when considering the center i has even string
        val str2 = findPalindrome(s,i,i+1)

        if(str1.length > str2.length){
            if (str1.length > longestPalindromeSubstring.length){
                longestPalindromeSubstring = str1
            }
        }else if(str2.length > longestPalindromeSubstring.length){
             longestPalindromeSubstring = str2
        }

    }

    return longestPalindromeSubstring
}

fun findPalindrome(s:String,left:Int,right:Int):String{

    var left = left
    var right = right

    while(left >= 0 && right <= s.lastIndex && s[left] == s[right]){
        left--
        right++
    }

    return s.substring(left+1,right)
}