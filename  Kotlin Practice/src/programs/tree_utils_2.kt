package programs

import java.util.LinkedList
import java.util.Queue

/*class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}*/

class BinaryTree {
    var root: TreeNode? = null

    fun insertLevelOrder(values: List<Int>) {
        val queue: Queue<TreeNode?> = LinkedList()
        var index = 0

        if (values.isEmpty()) {
            return
        }

        root = TreeNode(values[index++])
        queue.add(root)

        while (index < values.size) {
            val currentNode = queue.poll()

            val leftValue = values[index++]
            if (leftValue != -1) {
                currentNode?.left = TreeNode(leftValue)
                queue.add(currentNode?.left)
            }

            if (index >= values.size) {
                break
            }

            val rightValue = values[index++]
            if (rightValue != -1) {
                currentNode?.right = TreeNode(rightValue)
                queue.add(currentNode?.right)
            }
        }
    }

    fun printTree() {
        printNode(root, 0)
    }

    private fun printNode(node: TreeNode?, level: Int) {
        if (node != null) {
            printNode(node.right, level + 1)
            println(" ".repeat(level * 4) + node.`val`)
            printNode(node.left, level + 1)
        }
    }
}

fun main() {
    val values = listOf(120, 70, 140, 50, 100, 130, 160, 20, 55, 75, 110, 119, 135, 150, 200)
    val binaryTree = BinaryTree()

    binaryTree.insertLevelOrder(values)
    binaryTree.printTree()
}
