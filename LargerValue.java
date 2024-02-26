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
 //TimeComplexity:O(n)
 //SpaceComplexity:O(n)
 class Solution {
    List<Integer> result = new ArrayList<>();
    void largeValues(TreeNode root, int level) {
        if(root == null) {
            return;
        }
        int current = root.val;
        if(result.size() == level) {
            result.add(root.val);
        } else {
            result.set(level,Math.max(result.get(level), root.val));
        }
        largeValues(root.left, level+1);
        largeValues(root.right, level+1);
    }
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return result;
        }
          largeValues(root, 0);
          return result;
    }
}