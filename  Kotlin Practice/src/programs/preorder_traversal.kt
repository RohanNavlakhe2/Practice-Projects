package programs

fun main(){

}

fun preorder(root:BinaryTreeNode?){
    if(root != null){
        println(root.data)
        preorder(root.left)
        preorder(root.right)
    }
}