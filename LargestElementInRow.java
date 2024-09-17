T.C: O(N); N is No of nodes in a tree
S.C: O(H); H is max height of Tree
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            for (int i=0; i<queue.size(); i++){
                TreeNode node = queue.remove();
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                max = Math.max(max,node.val);
            }
            result.add(max);
        }
        return result;
    }
} 