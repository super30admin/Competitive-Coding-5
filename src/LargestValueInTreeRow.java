// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/**https://leetcode.com/problems/find-largest-value-in-each-tree-row/
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
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            int min = Integer.MIN_VALUE;
            
            while(size > 0) {
                TreeNode currNode = q.poll();
                if(currNode.val > min){
                    min = currNode.val;
                }
                
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
                size--;
            }
            
            res.add(min);
        }
        return res;
    }
}