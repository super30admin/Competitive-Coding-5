// Time Complexity : O(n), We traverse through all nodes once.
// Space Complexity : O(n/2) = O(n), A queue is created which would hold a maximum of n/2 values in worst case scenario(all leaf nodes)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
        List<Integer> result = new ArrayList<>();
        if(root==null)return result;
//Creating a queue to store all nodes of a level
        Queue<TreeNode> q = new LinkedList<>();
        int max=Integer.MIN_VALUE;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
//Comparing each node of a level with other nodes in the level
                if(curr.val>max) max = curr.val;
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
//Adding max value of a level to result array before moving to next level and resetting max value
            result.add(max);
            max=Integer.MIN_VALUE;
    
            
        }
        return result;
        
    }
}