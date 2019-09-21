/**
 * Idea: Use level order traversal to visit each row and track max, and add to the result list.
 * 
 * Space Complexity: O(n)
 * Time Complexity: O(n)
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        // base case
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int nodesLevel = q.size();
            int maxValue = Integer.MIN_VALUE;
            for(int i = 0; i < nodesLevel; i++) {
                TreeNode current = q.remove();
                maxValue = Math.max(maxValue, current.val);
                if(current.left != null) {
                    q.add(current.left);
                }
                if(current.right != null) {
                    q.add(current.right);
                }
            }
            result.add(maxValue);
        }
        
        return result;
    }
}