// Time Complexity : O(n)
// Space Complexity : O(height)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I did a regular level order traversal and added the max of each level to the result.

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
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i<levelSize; i++){
                TreeNode curr = queue.poll();
                max = Math.max(curr.val, max);
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            res.add(max);
        }
        return res;
    }
}