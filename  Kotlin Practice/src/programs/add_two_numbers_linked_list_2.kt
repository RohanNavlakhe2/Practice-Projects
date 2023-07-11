package programs

import java.math.BigInteger

fun main() {
    //addTwoNumbers2(prepareLinkedList(9), prepareLinkedList(1, 9, 9, 9, 9, 9, 9, 9, 9, 9))
    /* addTwoNumbers(prepareLinkedList(9), prepareLinkedList(1,9))
     addTwoNumbers(prepareLinkedList(1,2,5), prepareLinkedList(2,0,7))
     addTwoNumbers(prepareLinkedList(6,5,7), prepareLinkedList(4,5,6))
     addTwoNumbers(prepareLinkedList(2,7,6,4), prepareLinkedList(9,3,5,8))*/

    addTwoNumbers2(prepareLinkedList(2,4,3), prepareLinkedList(5,6,4))
    addTwoNumbers2(prepareLinkedList(9,9,9,9,9,9,9), prepareLinkedList(9,9,9,9))
    addTwoNumbers2(prepareLinkedList(0), prepareLinkedList(0))
    addTwoNumbers2(prepareLinkedList(9), prepareLinkedList(1, 9, 9, 9, 9, 9, 9, 9, 9, 9))
}

fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {

    var l1 = l1
    var l2 = l2
    var remainder = 0
    val newHead = ListNode(0)
    var current = newHead

    while (l1 != null || l2 != null) {
        val value = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + remainder
        current.next = ListNode(value % 10)
        current = current.next!!
        remainder = if (value >= 10) value / 10 else 0

        l1 = l1?.next
        l2 = l2?.next
    }

    if(remainder != 0){
        current.next = ListNode(remainder)
    }

    printLinkedList(newHead.next)

    return newHead.next
}

