/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

/*
 * class Solution {
 * // Tc: O(n) Sc: O(n)
 * List<Integer> res;
 * 
 * public List<Integer> largestValues(TreeNode root) {
 * res = new ArrayList<Integer>();
 * dfs(root, 0);
 * return res;
 * }
 * 
 * public void dfs(TreeNode root, int i) {
 * if (root == null)
 * return;
 * 
 * if (i == res.size())
 * res.add(root.val);
 * else
 * res.set(i, Math.max(res.get(i), root.val));
 * dfs(root.left, i + 1);
 * dfs(root.right, i + 1);
 * }
 * }
 * 
 */