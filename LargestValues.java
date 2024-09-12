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
 time complexity : O(n)
 Space complexity : O(log(n))
 */
class Solution {
    List<Integer> maxList;
    public List<Integer> largestValues(TreeNode root) {
        maxList = new ArrayList<>();
        if(root == null) return maxList;
        dfs(root,0);
        return maxList;
    }
    private void dfs(TreeNode root, int level){
        if(root == null) return;
        if(maxList.size() == level){
            maxList.add(root.val);
        }
        if(root.val > maxList.get(level)){
            maxList.set(level,root.val);
        }
        dfs(root.left, level+1);
        dfs(root.right, level+1);       
        
    }
}
