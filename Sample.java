//*****71.FIND LARGEST VALUE IN BST- BFS APPROACH****
// Time Complexity :0(N);
// Space Complexity :O(N);
// Did this code successfully run on Leetcode :Y
// Any problem you faced while coding this :N


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
        List<Integer> result= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        
        //Null case
        if(root==null)
        {
            return result;
        }
        
        //Add root to the queue
        q.add(root);
        
        
        //Process the queue by adding children and removing its parent
        while(!q.isEmpty())
        {
            
            int max=Integer.MIN_VALUE;
            int size=q.size();
            
            //Processing the level
            for(int i=0;i<size;i++)
            {
                TreeNode temp=q.poll();
                if(temp.val>max)
                {
                    max=temp.val;   
                }
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
                
            }
            result.add(max);
        }
      return result;  
    }
}
