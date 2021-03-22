/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class LargestValueInEachTreeRow {
    
    // Time Complexity: O(n)    (where n -> no. of nodes in the tree)
    // Space Complexity: O(n)
    
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // Edge Case Checking
        if(root == null)
            return result;
        
        // Initializing Queue for BFS
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // BFS
        while(!q.isEmpty()){
            int size = q.size();
            int maxVal = Integer.MIN_VALUE;
            
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                maxVal = Math.max(maxVal, curr.val);
                
                if(curr.left != null){
                    q.offer(curr.left);
                }
                
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            // Add the maximum value to the output list - only when we move to the next level
            result.add(maxVal);        
        }
        return result;
    }
}