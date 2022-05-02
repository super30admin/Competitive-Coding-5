import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem1 {
    // Definition for a binary tree node.
    public class TreeNode {
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
    //TC : O(n)
    //SC : O(n)
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curr = que.poll();
                if (curr.val > max) {
                    max = curr.val;
                }
                if (curr.left != null) {
                    que.add(curr.left);
                }
                if (curr.right != null) {
                    que.add(curr.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
