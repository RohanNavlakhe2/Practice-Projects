package programs

fun main() {
    /*println(maxVowels("abciiidef", 3))
    println(maxVowels("aeiou", 2))
    println(maxVowels("leetcode", 3))*/
    println(maxVowels("zpuerktejfp", 3))
}

fun maxVowels(s: String, k: Int): Int {

    val set = setOf('a', 'e', 'i', 'o', 'u')
    var windowCount = 0
    var vowelCount = 0


    var i = 0
    var j = 0

    while (j < s.length) {
        
        var previousIChar = ' '
        if (i != 0) {
            previousIChar = s[i - 1]
        }
        val jChar = s[j]

        if (j >= k) {

            if (set.contains(previousIChar)) {
                windowCount--
            }

            if (set.contains(jChar)) {
                windowCount++
            }

            vowelCount = Math.max(windowCount,vowelCount)

        } else if (set.contains(jChar)) {
            windowCount++
        }

        if (windowCount == k) {
            return windowCount
        }

        j++
        if (j >= k) {
            i++
            vowelCount = Math.max(windowCount,vowelCount)
        }

    }

    return vowelCount

}