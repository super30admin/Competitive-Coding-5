// Time Complexity : O(N)
// Space Complexity : O(Width of the tree) - BFS | O(Height of the tree) - DFS
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//BFS
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) q.add(root);
        while(!q.isEmpty()) {
            int qSize = q.size();
            // at every level we find the max during processing of queue,
            // add it to the end result
            int max = Integer.MIN_VALUE;
            for(int i=0;i<qSize;i++) {
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            result.add(max);
        }
        return result;
    }
}

//DFS
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
    private  List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int level) {
        if(root == null) return;
        // if value for the appropriate level ain't there, we add or update upon when curr max is lesser than curr
        if(result.size() == level)
            result.add(root.val);
        else
            result.set(level, Math.max(result.get(level), root.val));
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}