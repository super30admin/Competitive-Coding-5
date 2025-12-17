// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// Perform a level-order traversal (BFS) of the binary tree using a queue.
// At each level, find the maximum value among all nodes in that level.
// Add the maximum value of each level to the result list.

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
        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()){
            int size = q.size();
            int max_value = Integer.MIN_VALUE;  
            for(int i =0; i <size; i++){
                TreeNode curr = q.poll();
                if (curr.val > max_value){
                    max_value =  curr.val;
                }
                if (curr.left != null){
                    q.offer(curr.left);
                }
                if (curr.right != null){
                    q.offer(curr.right);
                }
            }
            result.add(max_value);
        }
        return result;
        
    }
}