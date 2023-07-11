package programs

fun main() {
   /* val root = TreeNode(50)
    root.left = TreeNode(40)
    root.left!!.left = TreeNode(30)
    root.left!!.right = TreeNode(45)

    root.right = TreeNode(60)
    root.right!!.left = TreeNode(55)
    root.right!!.right = TreeNode(65)

    println(isValidBST(root))

    val root2 = TreeNode(50)
    root2.left = TreeNode(40)
    root2.left!!.left = TreeNode(30)
    root2.left!!.right = TreeNode(51)

    root2.right = TreeNode(60)
    root2.right!!.left = TreeNode(55)
    root2.right!!.right = TreeNode(65)

    println(isValidBST(root2))*/

    val values = listOf(120, 70, 140, 50, 100, 130, 160, 20, 55, 75, 110, 119, 135, 150, 200)
    val binaryTree = BinaryTree()

    binaryTree.insertLevelOrder(values)
    println(isValidBST2(binaryTree.root))


}

fun isValidBST2(root: TreeNode?): Boolean {
    if(root == null) return false
    var result:Int? = 0
    if(root.left != null){
        result = findMaxInLeftSubtree2(root)
    }else if(root.right != null){
        result = findMinInRightSubtree2(root)
    }

    return result != null
}

fun findMaxInLeftSubtree2(root: TreeNode?): Int? {
    if (root != null) {
        val maxInLeft = findMaxInLeftSubtree2(root.left)
        val minInRight = findMinInRightSubtree2(root.right)
        if (maxInLeft == null || minInRight == null)
            return null
        return if (root.`val` > maxInLeft && root.`val` < minInRight) root.right?.`val` ?: root.`val` else null
    } else {
        return Integer.MIN_VALUE
    }
}

fun findMinInRightSubtree2(root: TreeNode?): Int? {
    if (root != null) {
        val maxInLeft = findMaxInLeftSubtree2(root.left)
        val minInRight = findMinInRightSubtree2(root.right)
        if (maxInLeft == null || minInRight == null)
            return null
        return if (root.`val` > maxInLeft && root.`val` < minInRight) root.left?.`val` ?: root.`val` else null
    } else {
        return Integer.MAX_VALUE
    }
}
