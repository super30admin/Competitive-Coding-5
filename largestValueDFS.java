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
// Space Complexity: recursive stack O(height) space complexity
// Did you complete it on leetcode: Yes
// Any problems faced: No

// Write your approach:
// Idea here is to recursively check max value at each level, we keep assigning initial root val to each index of list and once we recurse on right child we check if it is larger, we set that level value in result to max value
class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        if(root==null) return new ArrayList<>();
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    
    public void dfs(TreeNode root, int level) {
        // base
        if(root==null) return;
        // logic
        if(level==result.size()) {
            result.add(root.val);
        } else {
            result.set(level, Math.max(result.get(level), root.val));
        }
        dfs(root.left, level+1);
        dfs(root.right, level+1);
        
    }
}