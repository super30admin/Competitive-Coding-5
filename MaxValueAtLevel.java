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

 // Time Complexity : O(N)
// Space Complexity : O(H) : height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
/*Approach:
1) MaxValue of everyNode at each levels
2) Thus perform a BFS-> which will take in every level and for that we calculate the maxValue at every level
3) thus we need size of queue which will help us to update. 
4) we start from root node and maintain a local max and global max
5) global max will update at end of every level.
6) localMax will update for each value. 

*/


import java.util.*;

class MaxValueAtLevel {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }


    public List<Integer> largestValues(TreeNode root) {
             
        
        List<Integer> res = new ArrayList<>();
        
        if(root==null)
        {
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        
        while(!queue.isEmpty())
        {
            
            int size = queue.size();
            
            int maxVal=Integer.MIN_VALUE;
            
            for(int i=0;i<size;i++)
            {
                TreeNode n = queue.poll();
                
                
                
                maxVal = Math.max(n.val,maxVal);
                
                if(n.left!=null)
                {
                    queue.add(n.left);
                }
                
                if(n.right!=null)
                {
                    queue.add(n.right);
                }
                
            }
            
            res.add(maxVal);
        }
        
        
        return res;
    }
}
