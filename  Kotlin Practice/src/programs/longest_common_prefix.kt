package programs

fun longestCommonPrefix(strs: Array<String>): String {
    var longestCommonPrefix = strs[0]

    for (i in 1..strs.lastIndex) {
        val currentStr = strs[i]

        val loopUpto =
            if (longestCommonPrefix.length < currentStr.length) longestCommonPrefix.lastIndex else currentStr.lastIndex

        var j = 0
        while (j <= loopUpto) {
            if (longestCommonPrefix[j] != currentStr[j]) {
                longestCommonPrefix = longestCommonPrefix.substring(0 until j)
                break
            }

            j++
        }

        if(j == currentStr.length){
            if(currentStr.length < longestCommonPrefix.length){
                longestCommonPrefix = currentStr
            }
        }

    }

    return longestCommonPrefix
}