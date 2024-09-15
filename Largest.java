// Time Complexity :O(n)
// Space Complexity :O(max width of tree)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


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
       
        List<Integer> out= new ArrayList<>();
         if(root==null) return out;
        
        Queue<TreeNode> q = new LinkedList<>();//BFS to traverse along each level
        q.add(root);
        int max=Integer.MIN_VALUE;
        
        while(!q.isEmpty()){
            int size= q.size();
            
            for(int i=0;i<size;i++){
                
                TreeNode n= q.poll();
                if(n.val > max)//finding max
                    max=n.val;
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }
            
             out.add(max);
            max=Integer.MIN_VALUE;
        }
        
       return out;
        
    }
}
