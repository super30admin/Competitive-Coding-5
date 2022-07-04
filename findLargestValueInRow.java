//https://leetcode.com/problems/find-largest-value-in-each-tree-row/
// Time Complexity :O(n)  
// Space Complexity :O(n/2) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


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
        ArrayList<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size(); 
            int max=Integer.MIN_VALUE;
            ArrayList<Integer> temp=new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode curr= q.poll();
                if(curr.val>max)
                    max=curr.val;
                if(curr.left!=null) 
                {
                 
                    q.add(curr.left);
                }
                if(curr.right!=null) 
                {
                    
                    q.add(curr.right);
                }
              
            result.add(max);
        }
        return result;
    }
}