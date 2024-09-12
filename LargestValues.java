// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

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
        
        if(root == null) {
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
            
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
            
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                
            }
            res.add(max);
        }
        return res;
    }
}