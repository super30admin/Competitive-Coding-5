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

// Time Complexity : O(n)
// Space Complexity : O(n), for queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        LinkedList result = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return result;
        q.add(root);
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size = q.size(); 
            for(int i = 0; i<size;i++){
                TreeNode curr = q.poll();
                
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
                max = Math.max(curr.val,max);
            }
            result.add(max);
            max = Integer.MIN_VALUE;
            
        }
        return result;
    }
}