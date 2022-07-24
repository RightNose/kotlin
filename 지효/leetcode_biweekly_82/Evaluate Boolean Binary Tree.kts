/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun evaluateTree(root: TreeNode?): Boolean {
        if(root == null){
            return false
        }

        return when(root.`val`){
            0 -> false
            1 -> true
            2 -> evaluateTree(root.left) || evaluateTree(root.right)
            3 -> evaluateTree(root.left) && evaluateTree(root.right)
            else -> false
        }
    }
}
