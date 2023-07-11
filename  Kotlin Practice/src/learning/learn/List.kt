package learning.learn

fun main() {
  listTest()
//    listFind()
//    listMap()
//    listAscendingDescending()
//    listFilter()
//    listTest2()
}

fun defaultFunction(index:Int):Any{
   return "A"
}

fun listTest() {

    val list = mutableListOf<Any>()
    list.add("A")
    list.add("B")
    list.add("C")
    list.add("D")
    list.add("E")
    println(list)

    println(list[1])
    println(list.elementAt(1))
    println(list.elementAtOrElse(8,::defaultFunction))

    println(list.elementAtOrNull(8))


    var eList = mutableListOf<Any>()
    println(eList.isEmpty())
    println(list.isEmpty())


    var slices = list.slice(0..2)
    println(slices)

    var subList = list.subList(3,5)
    println(subList)
    println(list)
    


    var take = list.take(3)
    println(take)

    var takeLast = list.takeLast(2)
    println(takeLast)

    list[2] = "R"
    println(list)

    println(list.contains("R"))
    println(list.contains("Y"))

    list.add(3, "C")
    println(list)

    var ans = list.remove("H")
    println(ans)
    println(list)

    list.removeAt(0)
    println(list)

    val indexOfA = list.indexOf("A")
    println(indexOfA)
    list.add(indexOfA + 1, "Z")
    println(list)





}

fun listFind() {
    var list = mutableListOf(1, 'R', "Found", 2)
    var findList = list.find {
        if(it is Int){
            return@find (it.toInt())%2 == 0
        }
        return@find false
    }
    println(findList)

}

fun listMap(){
    val list = mutableListOf(0,1,2,4,5)
    var map = list.map {
        it%2 == 0
    }
    println(map)
}

fun listAscendingDescending() {
    val list2 = mutableListOf(25, 14, 10, 88, 3, 74, 19)
    list2.sort()    //nothing returns
    list2.sortDescending() //nothing returns

    var sortedAscendingOrder = list2.sorted().toMutableList()
    println(sortedAscendingOrder)
    println(sortedAscendingOrder.add(47))
    println(sortedAscendingOrder)

    println(list2.sortedDescending().toMutableList())


}

fun listFilter() {
    val list = mutableListOf(25, 10, 87, 47, 25, 10, 26)

    val evenNumList = list.filter {
        it % 2 == 0

    }
    println(evenNumList)

    val newEvenNumList = list.filterNot {
        it % 2 != 0

    }
    println(newEvenNumList)

    val oddNumList = list.filter {
        it % 2 != 0

    }
    println(oddNumList)

    val newOddNumList = list.filter {
        !(it % 2 == 0)

    }
    println(newOddNumList)


}

fun listTest2() {
    var list = mutableListOf<Any>(0, 1, 'R', "Found", true)

    list.forEach {
        println(it)
    }

    list.forEachIndexed { index: Int, any: Any ->
        println("$index $any")
    }

}