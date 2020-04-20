/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Time Complexity: O(n)
// Space COmplexity: O(maxDepth)

class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return res;
        }

        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        if(res.size() == level) {
            res.add(Integer.MIN_VALUE);
        }

        dfs(root.left, level + 1);
        int max = Math.max(res.get(level), root.val);
        res.remove(level);
        res.add(level, max);
        dfs(root.right, level + 1);

    }
}