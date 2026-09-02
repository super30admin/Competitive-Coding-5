// dfs
// time complexity  O(n)
// space complexity is of stack space o(n)


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
      List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {

    helper(root, 0);
      
      return result;
        
    }
    private void helper(TreeNode root , int height){
        if(root == null ){ return;}

        if(height == result.size()){
            result.add(root.val);
        } else {
           result.set(height,Math.max(result.get(height), root.val));
        }

        //left

        helper(root.left, height+1);
        //right

        helper(root.right, height+1);

    }
}
