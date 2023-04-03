class Solution {
    /**
    Time - O(N) no of nodes in tree.
    Space - O(N)
     */
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();

        if(root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList <TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.remove();
                max = Math.max(max, temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            result.add(max);
        }
        return result;
    }
}
