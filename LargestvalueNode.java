/*The time complexity of this implementation is O(n)
* and the space complexity is O(m) where m is maximum number of nodes*/
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LargestvalueNode {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // Edge case
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int maxVal = Integer.MIN_VALUE;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                maxVal = Math.max(maxVal, currNode.val);

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }

                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }

            result.add(maxVal);
        }

        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        LargestvalueNode solution = new LargestvalueNode();
        List<Integer> largestValues = solution.largestValues(root);

        System.out.println(largestValues);
    }

}
