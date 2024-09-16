class FindMaxBinaryTreeLevel {

    //Time Complexity: O(n)
    //Space Complexity: O(h)

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if (root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            int max = Integer.MIN_VALUE;
            int size = q.size();

            for (int i=0; i<size; i++) {

                TreeNode node = q.poll();

                if (node.val > max) {
                    max = node.val;
                }

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);

            }

            list.add(max);

        }
        return list;
    }

}