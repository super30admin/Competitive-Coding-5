import java.util.*;

//TC: O(N) Since we are traversing through all the elements. Wheree N is the height of the tree.
//SC: Since we are using a queue for auxilary purpose. It will O(N). where N is the number of nodes
public class LargestValueInEachRowBinaryTree_515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                max = Math.max(max, currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(max);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode().getSampleSeven();
        LargestValueInEachRowBinaryTree_515 largestValueInEachRowBinaryTree_515 = new LargestValueInEachRowBinaryTree_515();
        List<Integer> result = largestValueInEachRowBinaryTree_515.largestValues(root);
        System.out.println("The Largest in each row is:" + result);
    }
}
