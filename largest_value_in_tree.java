//Time complexity: o(n)
//space complexity: o(n)

public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = q.size();
//            result.add(max);
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (max < curr.val) {
                    max = curr.val;
                }
                if (root.left != null) q.add(root.left);
                if (root.right != null) q.add(root.right);
            }
            result.add(max);
        }
        return result;
    }
