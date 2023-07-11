package programs

fun main() {
    println(spiralOrder(
        arrayOf(
            intArrayOf(1,2,3,4),
            intArrayOf(5,6,7,8),
            intArrayOf(9,10,11,12),
            intArrayOf(13,14,15,16),
            intArrayOf(17,18,19,20),
            intArrayOf(21,22,23,24)
        )
    ))

    println(spiralOrder(
        arrayOf(
            intArrayOf(1,2,3),
            intArrayOf(4,5,6),
            intArrayOf(7,8,9)
        )
    ))

    println(spiralOrder(
        arrayOf(
            intArrayOf(1,2,3,4),
            intArrayOf(5,6,7,8),
            intArrayOf(9,10,11,12)
        )
    ))

    println(
        spiralOrder(
            arrayOf(
                intArrayOf(1,2,3)
            )
        )
    )
}

fun spiralOrder(matrix: Array<IntArray>): List<Int> {

    //jCount means how much far we have to go horizontally
    //In each iteration either to right side or to left side we decrease it by 1
    var jCount = matrix[0].size

    //iCount means how much far we have to go vertically
    //In each iteration either to bottom side or to top side we decrease it by 1
    var iCount = matrix.size - 1

    var i = 0
    var j = -1

    val list = mutableListOf<Int>()

    //We need to navigate Right -> Bottom and Left -> Top alternatively.
    //When shouldIncrement is true means go Right then Downside otherwise Left and Upside
    //Right -> j++, Downside -> i++, Left -> j--, Upside -> i--
    var shouldIncrement = true

    //When the list size is equal to matrix size we end the loop.
    while (list.size != matrix.size * matrix[0].size) {

        var tempJCount = jCount

        //This loop will either go to the right side or left side based on ShouldIncrement
        while (tempJCount != 0) {
            if(shouldIncrement) j++ else j--
            list.add(matrix[i][j])
            tempJCount--
        }

        jCount--

        var tempICount = iCount

        //This loop will either go to the top side or down side based on shouldIncrement
        while (tempICount != 0) {
            if(shouldIncrement) i++ else i--
            list.add(matrix[i][j])
            tempICount--
        }

        iCount--

        //We want to alternatively navigate Right then Downside and Left then Upside
        //So toggle shouldIncrement in each iteration.
        shouldIncrement = !shouldIncrement
    }

    return list
}