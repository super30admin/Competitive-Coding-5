//In this problem, we need to find the largest value in each row of a binary tree. 
// We are using bfs here, traversing the tree level by level and keeping track of the maximum value at each level.
// Time complexity is O(n) where n is the number of nodes in the tree, and
// space complexity is O(w) where w is the maximum number of nodes at any level.


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
    fun largestValues(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        if (root == null) return result

        val q = ArrayDeque<TreeNode>()
        q.add(root)

        while(q.isNotEmpty()) {
            var maxVal = Int.MIN_VALUE
            val size = q.size

            for(i in 0 until size){
                val node = q.removeFirst()
                maxVal = maxOf(node.`val`, maxVal)
                node.left?.let {q.add(it)}
                node.right?.let {q.add(it)}
            }

            result.add(maxVal) 
        }
        return result
    }
}