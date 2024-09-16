// Time Complexity : O(mxn)
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//515. Find Largest Value in Each Tree Row
//https://leetcode.com/problems/find-largest-value-in-each-tree-row/

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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        q.add(root);
        // list.add(root.val);
        while (!q.isEmpty()) {
            int size = q.size();
            // iterate through queue to find max
            int max = q.peek().val;
            for (TreeNode Q : q) {
                if (max < Q.val)
                    max = Q.val;
            }
            list.add(max);

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.peek();
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
                q.remove();
            }

        }
        return list;
    }
}