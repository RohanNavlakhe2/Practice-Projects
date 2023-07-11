package programs

fun main(){
  getIntersectionNode(prepareLinkedList(1,2,3,4), prepareLinkedList(5,6))
}

fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {

    var headA = headA
    var headB = headB
    val li1 = mutableListOf<ListNode>()
    val li2 = mutableListOf<ListNode>()


    while(headA != null || headB != null){

        headA?.let {
            li1.add(headA!!)
            headA = headA!!.next
        }

        headB?.let {
            li2.add(headB!!)
            headB = headB!!.next
        }

    }

    li1.forEach {
        print(" ${it.`val`} ")
    }

    li2.forEach {
        print(" ${it.`val`} ")
    }

    var li1Index = li1.lastIndex
    var li2Index = li2.lastIndex

    while(li1Index >= 0 && li2Index>=0){
        if(li1[li1Index] !== li2[li2Index]){
            return li1[li1Index].next
        }

        li1Index--
        li2Index--
    }

    return li1[li1Index+1]
}