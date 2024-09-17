package Competitive-Coding-5;
//Question Number :- 515 leetocde
public class problem2 {
 // Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        
        helper(root,0);
        return result;
    }
    public void helper(TreeNode root, int lvl){
        if(root == null) return;
         if(result.size() == lvl){
            result.add(root.val);
        }
        
        helper(root.left, lvl+1);
        helper(root.right, lvl+1);
        result.set(lvl,Math.max(result.get(lvl), root.val));
 
    }
}
