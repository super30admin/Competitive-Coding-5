// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no

public class LargestValueInEachRow {
    public List<Integer> largestValues(TreeNode root) {
        
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < size; i++) {
                
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                
                if(node.left != null) {
                    queue.add(node.left);
                }
                
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            
            result.add(max);
        }
        
        return result;
    }
}
