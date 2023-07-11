package programs

import java.util.*


class BinaryTreeNode(
    var data: Int,
    var left: BinaryTreeNode? = null,
    var right: BinaryTreeNode? = null
)

class TreeNode(var `val`: Int) {

    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object{

        fun insert(root: TreeNode?, key: Int): TreeNode {

            var root = root

            if (root == null) {
                root = TreeNode(key)
                return root
            }

            val q: Queue<TreeNode> = LinkedList<TreeNode>()
            q.add(root)
            // Do level order traversal until we find
            // an empty place.
            while (!q.isEmpty()) {
                root = q.peek()
                q.remove()
                if (root.left == null) {
                    root.left = TreeNode(key)
                    break
                } else q.add(root.left)
                if (root.right == null) {
                    root.right = TreeNode(key)
                    break
                } else q.add(root.right)
            }

            return root!!
        }
    }


}