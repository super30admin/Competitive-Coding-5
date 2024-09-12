/**
Problem: Largest value in every level of binary tree
Did it run on LeetCode: Yes

Time Complexity : O(n), where n is the number of nodes in the tree.
Space Complexity : O(n), where n is the number of nodes in the tree.

Approach: Level-order traversal.
1. We use BFS for solving this. To implement BFS, we make use of a queue.
2. Elements are added to the queue. Then, we traverse to the current node's children. At every level, we check for the max value.
3. Only the max element at every level is added to the final result list.

*/



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
//BFS
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) {
            q.add(root);
        }
        TreeNode curr;
        while(!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            
            for(int i = 0; i < size; i++) {
                curr = q.poll();
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
                max = Math.max(curr.val, max);
            }
            result.add(max);
        }
        return result;
    }
}