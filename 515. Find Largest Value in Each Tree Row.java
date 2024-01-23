// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        if(root == null) return Collections.emptyList();
        
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);

        while(!q.isEmpty()){
            int qSize = q.size();
            int rowMax = Integer.MIN_VALUE;

            while(qSize-- > 0){
                TreeNode item = q.poll();
                rowMax = Math.max(rowMax, item.val);
                if(item.left != null) q.offer(item.left);
                if(item.right != null) q.offer(item.right);
            }

            result.add(rowMax);
        }

        return result;
        
    }
}
