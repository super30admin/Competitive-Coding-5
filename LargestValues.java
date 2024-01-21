// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : BFS

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> result = new ArrayList();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        int maximum;

        while(!queue.isEmpty())
        {
            int size = queue.size();
            maximum = Integer.MIN_VALUE;

            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();

                if(node.val > maximum)
                {
                    maximum = node.val;
                }

                if(node.left != null) queue.add(node.left);
                
                if(node.right != null) queue.add(node.right);
            }

            result.add(maximum);

        }

        return result;
    }
}