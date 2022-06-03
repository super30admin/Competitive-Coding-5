// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
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
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> result = new ArrayList<>();
        if(root == null) return List.of();
        while(!q.isEmpty()){
            int size = q.size();
            int value= Integer.MIN_VALUE;
            for(int i=0; i< size; i++){
                TreeNode parent = q.poll();
                value = Math.max(value, parent.val);
                if(parent.left!=null) q.add(parent.left);
                if(parent.right!=null) q.add(parent.right);
            }
            result.add(value);
        }
        return result;
    }
}