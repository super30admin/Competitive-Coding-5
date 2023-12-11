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

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * DFS
 */
class Solution {

    List<Integer> result;

    public List<Integer> largestValues(TreeNode root) {

        if(root == null) return new ArrayList<>();

        this.result = new ArrayList<>();

        dfs(root, 0);

        return result;
    }

    private void dfs(TreeNode root, int level) {

        if(root == null) return;

        if(result.size() == level)
            result.add(root.val);
        else
            result.set(level, Math.max(root.val, result.get(level)));

        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}

/**
 * BFS without maintaining level
 */
/*
class Solution {
    public List<Integer> largestValues(TreeNode root) {

        if(root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {

            int size = q.size();
            int max = Integer.MIN_VALUE;

            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);

                if(node.left != null)
                    q.add(node.left);

                if(node.right != null)
                    q.add(node.right);
            }
            result.add(max);
        }

        return result;
    }
}*/

/**
 * BFS with maitaining level
 */
/*
class Solution {
    public List<Integer> largestValues(TreeNode root) {

        if(root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();

                if(result.size() == level)
                    result.add(node.val);
                else
                    result.set(level, Math.max(node.val, result.get(level)));

                if(node.left != null)
                    q.add(node.left);

                if(node.right != null)
                    q.add(node.right);
            }
            level++;
        }

        return result;
    }
}*/
