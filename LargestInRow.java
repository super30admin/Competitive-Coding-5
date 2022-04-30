import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class LargestInRow {


    // BFS approach
    // TC: O(n) n - number of nodes in a tree
    // SC: O(n) The exact value would be O(n/2). Ignoring the constant -> O(n)
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();

            int max = Integer.MIN_VALUE;
            for(int i=0; i < size; i++) {
                TreeNode current = queue.poll();

                max = Math.max(max, current.val);

                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
            result.add(max);
        }
        return result;
    }
}
