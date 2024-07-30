// Time Complexity: O(n), n:  number of nodes in the tree.
// Space Complexity: O(m), m: maximum number of nodes at any level in the tree.

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            int max = queue.peek().val;
            for(int i = 0; i < size; i++) {
                TreeNode deletedNode = queue.poll();
                max = Math.max(max, deletedNode.val);
                if(deletedNode.left != null)
                    queue.add(deletedNode.left);
                if(deletedNode.right != null)
                    queue.add(deletedNode.right);
            }
            result.add(max);
        }
        return result;
    }
}