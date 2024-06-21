/***
 Using BFS approach
 TC - O(n)
 SC - O(n)
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class MaxValueTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;

            for(int i =0; i < size; i++) {
                TreeNode curr = q.poll();

                max = Math.max(max, curr.val);

                if(curr.left != null)
                    q.add(curr.left);

                if(curr.right != null)
                    q.add(curr.right);
            }

            result.add(max);
        }

        return result;

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}