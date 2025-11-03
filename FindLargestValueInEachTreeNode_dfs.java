// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
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
        List<Integer> answer = new ArrayList<>();
        dfs(root,0,answer);
        return answer;
    }
    public void dfs(TreeNode root, int level, List<Integer> answer){
        if(root == null) return;
        if(answer.size() == level) answer.add(root.val);
        else answer.set(level, Math.max(answer.get(level), root.val));
        dfs(root.left, level+1, answer);
        dfs(root.right, level+1, answer);
    }
}
