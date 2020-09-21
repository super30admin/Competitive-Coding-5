// Time Complexity :O(N) N = no of nodes in a tree;
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
//1. Traverse the tree using BFS traversal.
//2. Maintain a variable that could keep a track of the max variable in each level.
//2. Adding that variable to the list would give us the desired result.

import java.util.*;

public class MaxInEveryLevel {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;

        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null)
            return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int qSize = q.size();
            // int res = 0;
            int max = Integer.MIN_VALUE;
            while (qSize-- > 0) {
                List<Integer> level = new ArrayList<>();
                TreeNode temp = q.poll();
                max = Math.max(temp.val, max);

                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);

            }

            ans.add(max);
        }

        return ans;

    }

    public static void main(String args[]) {

        MaxInEveryLevel obj = new MaxInEveryLevel();
        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(0);
        tree.left.right = new TreeNode(5);
        tree.left.left = new TreeNode(1);
        System.out.println(obj.largestValues(tree));

    }
}
