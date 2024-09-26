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
// Time Complexity: O(n) as all nodes will be traversed only once
// Space Complexity: queue of O(n) space complexity is used
// Did you complete it on leetcode: Yes
// Any problems faced: No

// Write your approach:
// Idea here is to add root to queue and check for each level by adding all
// children to queue and polling them upto size along with checking the maximum value
// at each completion of level add the maximum value to result list.
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);   
            }
            result.add(max);
        }
        return result;
    }
}