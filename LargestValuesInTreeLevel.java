
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None
 *
 * Approach:
 * 1. Do a BFS on each level
 * 2. Maintain a max variable to find max at each level
 * 3. Add max to the result.
 */
public class LargestValuesInTreeLevel {

    //Definition for a binary tree node.
    public static class TreeNode {

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

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size, max;
            size = q.size();
            max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                max = Math.max(max, temp.val);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }

            result.add(max);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;

        n2.left = new TreeNode(5);
        n2.right = new TreeNode(3);
        n3.right = new TreeNode(9);

        LargestValuesInTreeLevel obj = new LargestValuesInTreeLevel();
        List<Integer> largestValues = obj.largestValues(n1);
        System.out.println(largestValues);
        List<Integer> expected = Arrays.asList(1,3,9);
        assert (expected.equals(largestValues));
    }
}
