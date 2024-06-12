/**LC-515
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(H)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : Yes. At line 42...didnot get this logic
 * 
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
    List<Integer> maxList = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        
        if(root == null) return maxList;
        
        dfs(root, 0);
        return maxList;
        
    }
    
    public void dfs(TreeNode root, int level){
        
        //base
        if(root == null) return;
        

        if(maxList.size() == level){
            
            maxList.add(root.val);
            
        }
        else{
            
            if(root.val > maxList.get(level))
                maxList.set(level, root.val);
        }
        
        dfs(root.left, level+1);
        dfs(root.right, level+1);
        
    }
}










