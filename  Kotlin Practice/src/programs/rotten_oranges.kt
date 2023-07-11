package programs

import java.util.*

fun main() {
    println(
        orangesRotting(
            arrayOf(
                intArrayOf(2, 1, 1),
                intArrayOf(1, 1, 0),
                intArrayOf(0, 1, 1)
            )
        )
    )

    println(
        orangesRotting(
            arrayOf(
                intArrayOf(2, 1, 1),
                intArrayOf(0, 1, 1),
                intArrayOf(1, 0, 1)
            )
        )
    )

    println(
        orangesRotting(
            arrayOf(
                intArrayOf(0, 2)
            )
        )
    )


}

fun orangesRotting(grid: Array<IntArray>): Int {

    var queue = ArrayDeque<Pair<Int, Int>>()
    var tempQueue = ArrayDeque<Pair<Int, Int>>()
    var ans = 0
    var totalFresh = 0

    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 2) {
                tempQueue.push(Pair(i, j))
            } else if (grid[i][j] == 1) {
                totalFresh++
            }
        }
    }

    if (totalFresh == 0)
        return 0

    if(tempQueue.isEmpty()){
        return -1
    }

    var currentFresh = totalFresh

    do {
        val temp = queue
        queue = tempQueue
        tempQueue = temp

        val tempFresh = currentFresh
        ans++

        while (queue.isNotEmpty()) {
            val currentRottenOrange = queue.poll()
            val row = currentRottenOrange.first
            val col = currentRottenOrange.second

            val top = if (row - 1 == -1) 0 else grid[row - 1][col]
            val bottom = if (row + 1 == grid.size) 0 else grid[row + 1][col]
            val left = if (col - 1 == -1) 0 else grid[row][col - 1]
            val right = if (col + 1 == grid[row].size) 0 else grid[row][col + 1]

            if (top == 1) {
                grid[row - 1][col] = 2
                currentFresh--
                tempQueue.push(Pair(row - 1, col))
            }

            if (bottom == 1) {
                grid[row + 1][col] = 2
                currentFresh--
                tempQueue.push(Pair(row + 1, col))
            }

            if (left == 1) {
                grid[row][col - 1] = 2
                currentFresh--
                tempQueue.push(Pair(row, col - 1))
            }

            if (right == 1) {
                grid[row][col + 1] = 2
                currentFresh--
                tempQueue.push(Pair(row, col + 1))
            }
        }


    } while (currentFresh < tempFresh && currentFresh != 0)

    return if (currentFresh == 0) ans else -1
}