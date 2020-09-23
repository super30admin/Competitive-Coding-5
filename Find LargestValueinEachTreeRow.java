// Time Complexity : O(n) n = number of nodes
// Space Complexity : O(n) asymptotically it is n = number of nodes, but it would be O(n/2) 
                         //i.e. the size of the queue when it will be processing the last level in the binary tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        
        if(root == null)    return new ArrayList();
        
        List<Integer> output = new ArrayList();
        Deque<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            max = Integer.MIN_VALUE;
            
            for(int i = 0; i < size;i++){
                TreeNode node = queue.poll();
                
                max = Math.max(max, node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                
            }
            output.add(max);
        }
        return output;
    }
}
