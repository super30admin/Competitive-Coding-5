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

//Tme complexity is O(N) N is number of elements in tree
//Space complexity is O(N) as it is recursion
class Solution {
    List<Integer> result = new ArrayList();
    public List<Integer> largestValues(TreeNode root) {
        if(root==null){
            return result;
        }
        helper(root, 1);
        return result;
    }
    public void helper(TreeNode root, int dep){
        if(root==null){
            return;
        }
        if(result.size()<dep){
            result.add(root.val);
        }
        else{
            result.set(dep-1, Math.max(result.get(dep-1), root.val));
        }
        helper(root.left, dep+1);
        helper(root.right, dep+1);
    }
}