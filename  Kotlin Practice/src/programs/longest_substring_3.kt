package programs

/*1. We will keep a hashmap to keep track of the occurances of the characters. Key will be the character and value will be its index.
2. We will have two pointers (left and right).
3. To find a substring left will be static at one place until right finds a duplicate character that is already there in the map.
4. Once right finds a duplicate character means we found a substring and right-left will be the length of that substring.
5. Store the difference in one variable (lengthOfTheLongestSubstring)
6. Now left will be lastOccuranceOfTheChar's index + 1.*/

fun lengthOfLongestSubstring3(s: String): Int {

    var lengthOfLongestSubstring = 0
    val charMap = HashMap<Char,Int>()

    var left = 0
    var right = 0

    //We calculate the substring length between (right and left) and right can go utmost by s.length-1
    //So if s.length - left is less than the current known longest substring length then we can end the loop
    while(right < s.length && s.length - left > lengthOfLongestSubstring){

        val char = s[right]

        //Char already exist in the map

        //If the char's index is smaller than left then no need to find the substring length because
        //this is character's last occurance index and we calculate substring length only between right and left
        if(charMap[char] != null && charMap[char]!! >= left){
            lengthOfLongestSubstring = if(lengthOfLongestSubstring > right-left) lengthOfLongestSubstring else right-left
            left =  charMap[char]!! + 1

        }

        charMap[char] = right
        right++
    }


    return if(lengthOfLongestSubstring > right-left) lengthOfLongestSubstring else right-left
}



