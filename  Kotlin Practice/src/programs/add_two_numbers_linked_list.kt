package programs

fun main(){
    addTwoNumbers(prepareLinkedList(9), prepareLinkedList(1,9,9,9,9,9,9,9,9,9))
   /* addTwoNumbers(prepareLinkedList(9), prepareLinkedList(1,9))
    addTwoNumbers(prepareLinkedList(1,2,5), prepareLinkedList(2,0,7))
    addTwoNumbers(prepareLinkedList(6,5,7), prepareLinkedList(4,5,6))
    addTwoNumbers(prepareLinkedList(2,7,6,4), prepareLinkedList(9,3,5,8))*/
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

    var l1 = l1
    var l2 = l2
    var total = 0
    var multiplyBy = 1

    while (l1 != null || l2 != null) {
        total += (l1?.`val`?.times(multiplyBy) ?: 0) + (l2?.`val`?.times(multiplyBy) ?: 0)
        l1 = l1?.next
        l2 = l2?.next
        multiplyBy *= 10
    }

    println(total)

    val newHead = ListNode(0)

   /* if(total == 0){
        return newHead
    }

    var current = newHead

    while (total != 0){
        current.next = ListNode(total%10)
        current = current.next!!
        total /= 10
    }*/

    return newHead.next
}

