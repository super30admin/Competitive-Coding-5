/**
 * Problem: https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 * Approach - BFS
 * TC: O(n)
 * SC: O(n)
 **/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer max = null;
            
            for (int i = 0; i < size; ++i) {
                TreeNode num = queue.poll();
                
                if (max == null || num.val > max) {
                    max = num.val;
                }
                
                if (num.left != null) {
                    queue.add(num.left);
                }
                
                if (num.right != null) {
                    queue.add(num.right);
                }
            }
            res.add(max);
        }
        
        return res;
    }
}