package programs

fun main(){

}

class ListNode3(var `val`: Int) {
    var next: ListNode3? = null
}

fun mergeTwoLists(list1: ListNode3?, list2: ListNode3?): ListNode3? {

    var list1 = list1
    var list2 = list2

    val newHeadNode = ListNode3(0)
    var currentNode = newHeadNode

    while (list1 != null || list2!=null){

        if(list1 == null){
            currentNode.next = list2
            currentNode = currentNode.next!!
            list2 = list2?.next
            continue
        }

        if(list2 == null){
            currentNode.next = list1
            currentNode = currentNode.next!!
            list1 = list1.next
            continue
        }

        if(list1.`val` <= list2.`val`){
            currentNode.next = list1
            list1 = list1.next
        }else{
            currentNode.next = list2
            list2 = list2.next
        }

        currentNode = currentNode.next!!
    }

    return newHeadNode.next
}