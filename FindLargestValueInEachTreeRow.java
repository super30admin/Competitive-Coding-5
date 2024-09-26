// Time and space O(n) where n is the number of elements in the tree.
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
class Solution {List<Integer> res =new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root!=null)
            dfs(root, 0);
        return res;
    }
                
   private void dfs(TreeNode root, int level)
   {
       if(res.size()==level)
           res.add(root.val);
       
       else
       {
           int curr = res.get(level);
           int max = Math.max(curr, root.val);
           res.set(level, max);
       }
       
       if(root.left!=null)
           dfs(root.left,level+1);
       
       if(root.right!=null)
           dfs(root.right,level+1);
       
       
   }
                
}