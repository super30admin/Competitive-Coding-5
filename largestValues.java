
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;

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

class Main {
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // null case
        if (root == null)
            return result;
        // queue
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // result.add(root.val);

        // BFS
        while (!q.isEmpty()) {

            // for level we are mainting size
            int size = q.size();
            // to check max value at each level
            int max = Integer.MIN_VALUE;
            // traverse all node at each level
            for (int i = 0; i < size; i++) {
                // get current nodr
                TreeNode curr = q.poll();
                // if max value is less than current node update max value
                if (max < curr.val) {
                    max = curr.val;
                }
                // add left and right into the queue
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            // add max into result list
            result.add(max);
        }
        // return result;
        return result;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        System.out.println(largestValues(root));
    }
}