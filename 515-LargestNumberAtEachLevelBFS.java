/**LC-515
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N/2)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : Yes
 * 
 * Had difficulty for max value logic in for loop of size..
 
 */
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
        
        
        
        List<Integer> maxList = new ArrayList<>();
        if(root == null) return maxList;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        // maxList.add(root.val);
        while(!q.isEmpty()){
            
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i< size; i++){
                
                TreeNode curr = q.poll(); 
                if(curr.val > max) max = curr.val;
                if(curr.left != null)  q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                
            }
            
            maxList.add(max);
        }
        return maxList;
        
    }
}