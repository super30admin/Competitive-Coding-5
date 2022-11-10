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
//Time: O(n)
//Space: O(h)
class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        result = new ArrayList<>();
        
        dfs(root, result, 0);
        
        return result;
    }
    
    private void dfs(TreeNode root, List<Integer> result, int height){
        if(root == null)
            return;
        if(height == result.size())
            result.add(root.val);
        else
            result.set(height, Math.max(result.get(height), root.val));
        
        dfs(root.left, result, height + 1);
        dfs(root.right, result, height + 1);
    }
}
