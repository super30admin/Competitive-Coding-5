// Time Complexity : O(n); where n = number of nodes present in the tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            // to maintain the size of the level
            int size  = q.size();
            // to maintain max value of each level
            int max = Integer.MIN_VALUE;
            
            // Level wise proccessing
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                // check whether the current node's value is greater than max value
                if(curr.val > max){
                    // update max to current node's value
                    max = curr.val;
                }
                
                // adding children of the current node
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            // adding max of each level to the result
            result.add(max);
        }
        return result;
    }
}