// Time Complexity : The time complexity is O(n) where n is the number of tree nodes
// Space Complexity : The space complexity is O(n) where n is the number of tree nodes
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

    List<Integer> output;

    public List<Integer> largestValues(TreeNode root) {

        output = new ArrayList<>();

        if(root == null){
            return output;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int size = q.size();
        int max = Integer.MIN_VALUE;

        while(!q.isEmpty()){

            TreeNode cur = q.poll();
            max = Math.max(max,cur.val);
            size--;

            if(cur.left != null){
                q.offer(cur.left);
            }

            if(cur.right != null){
                q.offer(cur.right);
            }

            // Traverse through every level and find its maximum
            if(size == 0){
                output.add(max);
                size = q.size();
                max = Integer.MIN_VALUE;
            }
        }

        return output;
    }
}