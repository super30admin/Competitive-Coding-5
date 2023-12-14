// Time Complexity :O(N)
// Space Complexity :O(W), W- maximum width of the tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
       

        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;

         Queue<TreeNode> q= new LinkedList<>();
         q.add(root);

         while(!q.isEmpty())
         {
             int size =q.size();
             int maxi=Integer.MIN_VALUE;
             for(int i=0;i<size;i++)
             {
                 TreeNode curr= q.poll();

                 if(curr.left!=null)
                    q.add(curr.left);

                 if(curr.right!=null)
                    q.add(curr.right);

                    maxi= Math.max(maxi,curr.val);
             }
             result.add(maxi);
         }
       
        return result;
        
    }
}