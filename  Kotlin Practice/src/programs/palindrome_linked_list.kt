package programs

class ListNode4(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {

}

fun isPalindrome(head: ListNode?): Boolean {

    var head = head
    val str = StringBuilder()

    while (head != null) {
        str.append(head.`val`)
        head = head.next
    }

    //return str.toString() == str.toString().reversed()
    return str.equals(str.reversed())

}