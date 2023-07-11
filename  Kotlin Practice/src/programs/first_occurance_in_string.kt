package programs

fun main(){
    println(strStr("leetcode","leeto"))

}

fun strStr(haystack: String, needle: String): Int {

   if(haystack.length < needle.length){
       return -1
   }

    for(i in 0..haystack.length - needle.length){
        if(haystack[i] == needle[0] && haystack.substring(i,i+needle.length) == needle){
            return i
        }
    }

    return -1
}