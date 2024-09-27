/**
 * Definition for a binary tree node.
 // Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// 	Very diffcult to predict.

// Your code here along with comments explaining your approach
 
 
 /* public class TreeNode {
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
                List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root != null) q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < len; i++){
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            ans.add(max);
        }

        return ans;

    }
}