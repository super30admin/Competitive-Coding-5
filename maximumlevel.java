class Solution {
    List<Integer> result;
    int max = Integer.MIN_VALUE;

    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // result.add(root.val);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeNode curr = new TreeNode();
            for (int i = 0; i < size; i++) {
                curr = q.poll();
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
                max = Math.max(max, curr.val);
            }
            result.add(max);
            max = Integer.MIN_VALUE;
        }
        return result;
    }
}