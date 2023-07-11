package programs

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {

}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {

    var head = head

    val arr = Array<ListNode?>(30) {
        null
    }

    var i = 0
    var current = head

    while (current?.next != null){
        arr[i] = current
        current = current.next
        i++
    }

    val nodePriorDeleteNodeIndex = i - n
    if(nodePriorDeleteNodeIndex == -1){
        //means node to be deleted is the first node
        head = head?.next
        return head
    }


    val nodeComesBeforeDeleteNode = arr[nodePriorDeleteNodeIndex]
    nodeComesBeforeDeleteNode?.next =  arr[nodePriorDeleteNodeIndex + 1]?.next

    return head
}

