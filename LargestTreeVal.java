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
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        this.result= new ArrayList<>();
        dfs(root,1);
        return result;
        
    }
    private void dfs(TreeNode root,int level){

        if(root==null) return;
        int size = this.result.size();

        if(size<level){
            result.add(root.val);
        }else if(result.get(level-1) < root.val){
            result.set(level-1, root.val);
        }

        dfs(root.left,level+1);
        dfs(root.right,level+1);

    }
}