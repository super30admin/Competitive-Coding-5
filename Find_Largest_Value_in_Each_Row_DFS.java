// 515. Find Largest Value in Each Tree Row - https://leetcode.com/problems/find-largest-value-in-each-tree-row/
// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        // base
        if(root==null) return result;
        
        dfs(root,0);
        return result;
    }
    
    private void dfs(TreeNode root, int level){
        // base
        if(root == null) return;
        // logic
        if(result.size()==level){
            result.add(root.val);
        }
        else if(result.get(level) < root.val){
            result.set(level, root.val);
        }
        
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}