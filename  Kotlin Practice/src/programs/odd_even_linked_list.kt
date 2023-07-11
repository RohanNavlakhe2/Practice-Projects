package programs

fun main(){
    var res = oddEvenList(prepareLinkedList(1,2,3,4,5))
    //printLinkedList(res)
}

fun oddEvenList(head: ListNode?): ListNode? {

    var head = head
    val oddHead = ListNode(0)
    var currentOdd = oddHead
    val evenHead = ListNode(0)
    var currentEven = evenHead
    var count = 1

    while (head!=null){
        if(count%2==0){
            //even
            currentEven.next = head
            currentEven = currentEven.next!!
        }else{
            //odd
            currentOdd.next = head
            currentOdd = currentOdd.next!!
        }

        count++
        head = head.next
        currentEven.next = null
        currentOdd.next = null
    }

    currentOdd.next = evenHead.next

    return oddHead.next
}