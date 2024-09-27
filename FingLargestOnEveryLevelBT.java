// Time Complexity : O(n) n = num of nodes
// Space Complexity : O(n/2 +k) ----> O(n)
// Did this code successfully run on Leetcode :  yes
// Any problem you faced while coding this : no


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
        // null case
        if(root == null)
           return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode curr = q.poll();
                max = Math.max( curr.val , max);
                
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
            
            result.add(max);
            max = Integer.MIN_VALUE;
        }
        
        return result;
    }
}