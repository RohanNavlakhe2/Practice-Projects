package programs

fun main() {
    shiftZerosToRight(intArrayOf(1, 3, 0, 5, 4, 0, 2, 0, 0)).printResults()
    shiftZerosToRight(intArrayOf(0, 0, 2, 3, 7, 0, 8)).printResults()
    shiftZerosToRight(intArrayOf(2, 5, 6, 0, 0, 0)).printResults()
}

fun shiftZerosToRight(arr: IntArray): IntArray {

    var zeroPointer = 0

    arr.forEachIndexed { index, value ->

        if (value != 0) {
            swap2(arr, index, zeroPointer)
            zeroPointer++
        }

    }

    return arr
}

fun swap2(arr: IntArray, nonZeroPointer: Int, zeroPointer: Int) {
    val temp = arr[zeroPointer]
    arr[zeroPointer] = arr[nonZeroPointer]
    arr[nonZeroPointer] = temp
}