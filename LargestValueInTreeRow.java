public class LargestValueInTreeRow {
    // TC: O(N) where N is number of nodes
    // SC: O(D) where D is diameter of tree
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int currMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                currMax = Math.max(currMax, currNode.val);
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            res.add(currMax);
        }
        return res;
    }
}
