//QA-2

fun main() {

    val arr = arrayOf(2, 2, 3, 4, 5, 5)
    checkIfIncreasing2(arr, arr.size)  //yes

    val arr2 = arrayOf(2, 2, 3, 4, 4, 5, 5)
    checkIfIncreasing2(arr2, arr2.size) //No

    val arr3 = arrayOf(50, 60, 60, 70, 80)
    checkIfIncreasing2(arr3, arr3.size) //YES

    val arr4 = arrayOf(50, 60,70, 80)
    checkIfIncreasing2(arr4, arr4.size) //YES

    val arr5 = arrayOf(25,26,27,27,27,27,28)
    checkIfIncreasing2(arr5, arr5.size) //No

    val arr6 = arrayOf(25,26,27,27,27,28)
    checkIfIncreasing2(arr6, arr6.size) //YES


}

fun checkIfIncreasing2(arr: Array<Int>, length: Int) {
    var isIncreasing = false

    for (i in 0 until length - 1) {
        for (j in i + 1 until length) {
            var value: Int? = null

            for (k in arr.indices) {
                if (k != i && k != j) {
                    if (value == null) {
                        value = arr[k]
                        isIncreasing = true
                    } else if (arr[k] > value) {
                        value = arr[k]
                        isIncreasing = true
                    } else {
                        isIncreasing = false
                        break
                    }
                }
            }

            if (isIncreasing) {
                println("YES")
                return
            }
        }
    }

    println("NO")
}