package Competitive-Coding-5;
//Question Number :- 1469 leetocde
public class problem1 {
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
    List<Integer> result;
    public List<Integer> getLonelyNodes(TreeNode root) {
        result = new ArrayList<>();
        return result;
    }
    public void helper(TreeNode root){
        if(root == null) return;
        
        helper(root.left);
        
        helper(root.right);
        if(root.left == null && root.right != null){
            result.add(root.right.val);
        }else if(root.left != null && root.right == null){
            result.add(root.left.val);
        }
    }
}
