// https://leetcode.com/problems/find-largest-value-in-each-tree-row/

// Time Complexity: O(n) Touching each node
// Space Complexity: O(h) 
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No


class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        // null case
        if (root == null)
            return result;

        q.add(root);

        while (!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.val > max) {
                    max = curr.val;
                }
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            result.add(max);
        }
        return result;
    }
}