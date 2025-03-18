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
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        this.result = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode root, int level) {
        if (root == null)
            return;

        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        
        if (level % 2 == 0) {
           result.get(level).add(root.val);

        } else{
            result.get(level).add(0,root.val);

        }
         helper(root.left, level + 1);
         helper(root.right, level + 1);

    }
}
