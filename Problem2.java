class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Integer max = Integer.MIN_VALUE;
            // level processing
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                max = Math.max(temp.val, max);
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            result.add(max);
        }
        return result;
    }
}