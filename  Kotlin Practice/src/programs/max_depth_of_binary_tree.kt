package programs


fun main(){

}

fun maxDepth(root: TreeNode?): Int {
    return preorder(root,0,0)
}

fun preorder(root: TreeNode?, maxDepth:Int, currentDepth:Int):Int{

    var currentDepth = currentDepth
    var maxDepth = maxDepth

    if(root != null){
        currentDepth++
        maxDepth = preorder(root.left,maxDepth,currentDepth)
        return preorder(root.right,maxDepth,currentDepth)
    }else{
        return Math.max(currentDepth,maxDepth)
    }
}