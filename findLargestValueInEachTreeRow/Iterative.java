package findLargestValueInEachTreeRow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time Complexity : O (n) (n = nodes in tree)
// Space Complexity : O (n)
// Did this code successfully run on Leetcode : Yes

/**
 *  we will be storing all the values of every level in the queue then we will be finding the largest of all the values
 *  for every level and then we will proceed the same .This is iterative approach
 *
 *  https://www.thes30.com/problem/5d00c668b190ff0017faa59a
 */

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
class Iterative {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int max = Integer.MIN_VALUE;
            int count = q.size();

            for (int i = 0; i < count; i++) {
                TreeNode node = q.poll();

                if (node.val > max) {
                    max = node.val;
                }

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }

            result.add(max);
        }

        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}