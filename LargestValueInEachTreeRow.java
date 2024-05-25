// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Approach - Level Order Traversal (BFS using queue, tracking the max value in each row)

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
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();;

        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            int max=Integer.MIN_VALUE;

            for(int i=0;i< size;i++) {
                TreeNode curr = queue.poll();

                max = Math.max(max, curr.val);

                if(curr.left != null){
                    queue.add(curr.left);
                }

                if(curr.right != null) {
                    queue.add(curr.right);
                }

            }
            result.add(max);
        }

        return result;
    }
}