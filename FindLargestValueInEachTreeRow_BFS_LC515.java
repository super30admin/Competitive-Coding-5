// Time Complexity : O(n) n= no. of the node's
// Space Complexity : O(h) h= height of the tree/levels for result list size
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES while compaaring it with previous values of level for max.


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
class FindLargestValueInEachTreeRow_BFS_LC515 {
            List<Integer> result = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        // base case
        if (root == null) return result;
        bfs(root);
        return result;
    }

    private void bfs(TreeNode root) {
        // logic
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                max = Math.max(tempNode.val, max);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
            }            
            result.add(max);
        }

    }
}