package programs

class ListNode2(var `val`: Int) {
    var next: ListNode2? = null
}

fun main() {

}

fun reverseList(head: ListNode2?): ListNode2? {

    var head = head

    if(head?.next == null)
        return head

    var prev = head
    var after = head.next
    head.next = null


    while(after?.next != null){
        val tempNode = after.next
        after.next = prev
        prev = after
        after = tempNode
    }

    head = after
    head?.next = prev

    return head

}