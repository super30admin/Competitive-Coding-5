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
Time complexity O(n) space complexity O(1)
 */

class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        result=new ArrayList<>();
        if(root==null) return result;
        helper(root,0);
            return result;
    }
    private void helper(TreeNode root,int level){
        if(root==null)return;
        if(result.size()==level){
            result.add(root.val);
        }
        else{
            result.set(level,Math.max(root.val,result.get(level)));
        }
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
}