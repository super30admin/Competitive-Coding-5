// Time Complexity : O(n) [Number of nodes]
// Space Complexity : O(h) [Height of the tree worst case is total number of nodes O(n) for skewed trees]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


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
    List<Integer> result;

    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        helperDfs(root, 0);
        // helperBfs(root);
        return result;
    }

    private void helperDfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (result.size() == level) {
            result.add(root.val);
        } else {

            if (root.val > result.get(level)) {
                result.set(level, root.val);
            }
        }

        if (root.left != null) {
            helperDfs(root.left, level + 1);
        }

        if (root.right != null) {
            helperDfs(root.right, level + 1);
        }
    }

    private void helperBfs(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode currNode = q.poll();
                max = Math.max(max, currNode.val);
                if (currNode.left != null) {
                    q.offer(currNode.left);

                }
                if (currNode.right != null) {
                    q.offer(currNode.right);
                }
            }

            result.add(max);
        }
    }
}