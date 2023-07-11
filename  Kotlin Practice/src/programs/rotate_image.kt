package programs

fun main() {
     /*rotate(arrayOf(
         intArrayOf(5,1,9,11),
         intArrayOf(2,4,8,10),
         intArrayOf(13,3,6,7),
         intArrayOf(15,14,12,16)
     ))*/

    rotate(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
    )
}

fun rotate(matrix: Array<IntArray>): Unit {

    for (i in 0 until matrix.size / 2) {
        for (j in i until matrix.lastIndex - i) {
            shiftNumber(matrix, matrix[i][j], destinationI = j, destinationJ = matrix.size - i - 1, recursionCount = 3)
        }
    }

    for (i in 0..matrix.lastIndex) {
        for (j in 0..matrix.lastIndex) {
            print(" ${matrix[i][j]} ")
        }
        println()
    }
}


fun shiftNumber(matrix: Array<IntArray>, sourceNumber: Int, destinationI: Int, destinationJ: Int, recursionCount: Int) {

    if (recursionCount != 0) {
        shiftNumber(
            matrix,
            matrix[destinationI][destinationJ],
            destinationJ,
            matrix.size - destinationI - 1,
            recursionCount - 1
        )
    }

    matrix[destinationI][destinationJ] = sourceNumber
}