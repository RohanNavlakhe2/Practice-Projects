package learning.learn

fun main() {
    val s = "Substring"
    val substringOfS = s.substring(3)
    val substringOfS2 = s.substring(0, 3)
    val substringOfS3 = s.substring(3..5)

    println("Substring : $substringOfS, $substringOfS2, $substringOfS3")

    val a = "this is a pen"
    val capitalizedA = a.capitalize()
    println("Capitalized : $capitalizedA")

    val decapitalizedA = a.decapitalize()
    println("Decapitalized : $decapitalizedA")

    val aEndsWithPen = a.endsWith("PeN", true)
    println("Ends with : $aEndsWithPen")
    val aStartsWithPen = a.startsWith("pen")
    println("Starts with : $aStartsWithPen")

    val b = "vnksnvaepu"
    val vowelsStr = b.filter {
        //it.equals('a', true) || it.equals('e', true)
        return@filter it.equals('a', true) || it.equals('e', true)
    }
    println("Vowels str : $vowelsStr")

    val filterIndexed = b.filterIndexed { index, c ->
        index % 2 == 0
    }
    println("Filter Indexed : $filterIndexed")

    val c = "Tesla"
    val replacedC = c.replace('e', 'a')
    println("Replaced : $replacedC")


    val d = "Samsung%Apple%Oneplus"
    val replacedAfter = d.replaceAfter("%", "Galaxy","%")
    println("Replace After : $replacedAfter")

    val e = "Samsung%Apple%LG%Lenovo"
    val replaceAfterLast = e.replaceAfterLast("%", "Galaxy")
    println("Replace After Last : $replaceAfterLast")

    val f = "bag"
    val g = "this is a BAg"
    val contains = g.contains(f, true)
    println("Contains : $contains")

    val reversedStr= g.reversed()
    println("Reversed : $reversedStr")  //"gAB a si siht"

    val h = "My name is = rohan"
    val remove = h.removeRange(0..6)
    println("Remove : $remove")

    val removePrefix = h.removePrefix("My")
    println("Remove Prefix : $removePrefix")

    val removeSurrounding = h.removeSurrounding("My","rohan")
    println("removeSurrounding : $removeSurrounding")

    val countOfA =  h.count{
        it == 'a'
    }
    println("Count of a : $countOfA")

    val indexofAAfter5thIndex = h.indexOf("a",5)
    println("Index of A : $indexofAAfter5thIndex")


    for(i in h.indices){
        println(i)  //0 1 2 ....
    }

    val plus = h.plus("Abc")
    println("plus : $plus")

    val roh = "Rohan"
    val sau = "Saurabh"
    println("Rohan compareTo Saurabh : ${roh.compareTo(sau)}")

    h.filterIndexed(::abc)


    h.forEach(::test)
    h.forEach({

    })



}

fun test(char:Char){

}

fun abc(i:Int,c:Char):Boolean{
    return true
}

