// Time Complexity : O(N)
// Space Complexity :O(N)max 2^N element sized queue
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
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
        {return result;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max;
        while(!queue.isEmpty())
        {int size = queue.size();
         max = Integer.MIN_VALUE;
         for(int i = 0;i<size;i++)
         {  TreeNode front = queue.poll();
             if(front.val> max ){
                 max = front.val; }
          if(front.left != null)
              queue.add(front.left);
          if(front.right != null)
              queue.add(front.right);
         }
          result.add(max);  
        }
        return result;
    }
}