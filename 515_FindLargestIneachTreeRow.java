// Time Complexity : O(nodes in the tree)
// Space Complexity : O(width of the tree)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

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
        List<Integer> result = new LinkedList<>();
        
        if(root==null)
            return result;
        
        q.add(root);
        
        while(!q.isEmpty()){
            int max=Integer.MIN_VALUE;
            int size = q.size();
            
            for(int i=0;i<size;i++){
                TreeNode tmpNode = q.poll();
                max = Math.max(max,tmpNode.val);
                
                if(tmpNode.left!=null)
                    q.add(tmpNode.left);
                
                if(tmpNode.right!=null)
                    q.add(tmpNode.right);
            }
            
            result.add(max);
        }
        
        return result;
    }
}