package learning.learn

fun main() {

    val str = "Hello, World! "

// Print the length of the string
    val length = str.length
    println("Length : $length")  // Output: 13

// Check if the string is empty
    println(str.isEmpty())  // Output: false

// Get a substring of the string
    val sub = str.substring(7, 13)
    println(sub)  // Output: World!

// Split the string into a list of words
    val words = str.split(" ")
    println(words)  // Output: [Hello, World!]

// Check if the string contains a specific character sequence
    println(str.contains("Hello"))  // Output: true

// Replace a part of the string with another string
    val newStr = str.replace("World", "Kotlin")
    println(newStr)  // Output: Hello, Kotlin!

// Check if the string starts with a specific prefix
    println(str.startsWith("Hello"))  // Output: true

// Check if the string ends with a specific suffix
    println(str.endsWith("!"))  // Output: true

// Convert the string to lower case
    val lower = str.toLowerCase()
    println(lower)  // Output:    hello, world!

// Convert the string to upper case
    val upper = str.toUpperCase()
    println(upper)  // Output:   HELLO, WORLD!

// Trim leading and trailing white space characters
    val trim = str.trim()
    println(trim)  // Output: Hello, World!

// Pad the start of the string with a specific character
    val paddedStart = str.padStart(20, '*')
    println(paddedStart)  // Output: ********Hello, World!

// Pad the end of the string with a specific character
    val paddedEnd = str.padEnd(20, '*')
    println(paddedEnd)  // Output:    Hello, World!********

// Remove a range of characters from the string
    val removed = str.removeRange(7, 13)
    println(removed)  // Output:    Hello, !

// Repeat the string a specific number of times
    val repeated = str.repeat(3)
    println(repeated)  // Output:    Hello, World!    Hello, World!    Hello, World!


}
