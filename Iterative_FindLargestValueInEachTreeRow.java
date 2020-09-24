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
      
        //to store TreeNodes from each level of the given tree
        Deque<TreeNode> queue = new LinkedList();
        queue.offer(root);
      
        //initialize the max to minimum value of integer so as to obtain the valid 
        //maximum value in corner cases; for e.g. if the nodes have negative numbers
        int max = Integer.MIN_VALUE;
        
        while(!queue.isEmpty()){
            // size of the queue at each level
            int size = queue.size();
            max = Integer.MIN_VALUE;
            
          //traverse the queue and add it's left and right children if present
            for(int i = 0; i < size;i++){
                TreeNode node = queue.poll();
                
                //calculate maximum value which will be separate for each level
                max = Math.max(max, node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                
            }
            //add maximum value to the output arraylist
            output.add(max);
        }
        return output;
    }
}
