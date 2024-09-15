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
/**
 * Time Complexity: O(N) where N is the number of nodes in the binary tree
 * Space Complexity: O(N) where N is the number of nodes in binary tree
 * LeetCode: Y (https://leetcode.com/problems/find-largest-value-in-each-tree-row/)
 * Approach:
 *       Initalize Queue
 *       Enqueue root
 *       while queue is not empty
 *           get the size of the queue
 *           loop until the size keeping track of max and enqueuing valid children nodes
 *           append the max to the result
 *       return result
*/
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        // Initialize result arraylist
        List<Integer> result = new ArrayList<>();
        
        // check edge case
        if(root == null) {
            return result;
        }
        
        // initialize queue
        Queue<TreeNode> q = new LinkedList<>();
        
        // enqueue root
        q.add(root);
        
        // variable to track running maximum at each level
        int levelMax = Integer.MIN_VALUE;
        
        // traverse through the entire tree level-wise with size
        while(!q.isEmpty()) {
            // get the number of nodes at current level
            int size = q.size();
            // minimize levelMax initially to track running maximum at each level
            levelMax = Integer.MIN_VALUE;
            
            // iterate through the nodes at current level
            for(int i = 0 ; i < size ; i++) {
                // get the node at front of the queue
                TreeNode currentNode = q.poll();
                
                // update levelMax if the value at current node is greater than current max 
                levelMax = Math.max(levelMax, currentNode.val);
                
                // if there is a valid left child of current node then enqueue its left child
                if(currentNode.left != null) {
                    q.add(currentNode.left);
                }
                
                // if there is a valid right child of current node then enqueue its right child
                if(currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
            // add the calculated level max to the resultlist
            result.add(levelMax);
        }
        
        // return result
        return result;
        
    }
}
