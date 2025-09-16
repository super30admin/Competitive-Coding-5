// Time Complexity : O(n) where n is the total number of tree nodes
// Space Complexity : O(n) where n is the total number of tree nodes
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
public class GreatestValueInEachRow {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }
    static List<Integer> largestValues(TreeNode root) {
        List<Integer> sol = new ArrayList<>();

        if(root == null) return sol;
        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);

        while(!que.isEmpty()) {
            int len = que.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < len; i++) {
                TreeNode temp = que.poll();
                max = Math.max(max, temp.val);
                if(temp.left != null) que.add(temp.left);
                if(temp.right != null) que.add(temp.right);
            }
            sol.add(max);
        }

        return sol;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println("Largest Values in each row: " + largestValues(root));
    }
}
