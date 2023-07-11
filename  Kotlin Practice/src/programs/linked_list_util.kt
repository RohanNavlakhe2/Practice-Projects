package programs

fun prepareLinkedList(vararg values:Int):ListNode?{

    val dummy = ListNode(0)
    var current = dummy
    values.forEach {
        current.next = ListNode(it)
        current = current.next!!
    }

    return dummy.next
}

fun printLinkedList(head:ListNode?){

    var head = head

    val list = mutableListOf<Int>()

    if(head == null){
        println(list)
        return
    }

    while (head != null){
        list.add(head.`val`)
        head = head.next
    }

    println(list)
}