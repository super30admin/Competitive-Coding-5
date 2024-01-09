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

/**
 * Dfs approach, we recurse to the left child, and add it to the result list.
 * result list's index, represent s level in Binary tree!
 * TC: O(n)
 * sc: O(h)
 */
class Solution {

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        // base case
        if (root == null)
            return result;

        dfs(root, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> list, int level) {
        // base case
        if (root == null)
            return;

        dfs(root.left, new ArrayList<>(), level + 1);
        dfs(root.right, new ArrayList<>(), level + 1);
    }
}