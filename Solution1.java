//Time complexity: O(N), where N is the number of nodes in the tree
//Space complexity: O(H), where H is the maximum height of the tree


import java.util.*;

class Solution1 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    
    List<Integer> output; 
    
    private void dfs(TreeNode root, int level) {
        //base case
        if(root == null) return; 
        if(output.size() == level) {
            output.add(root.val);
        } else {
            if(output.get(level) < root.val) {
                output.set(level, root.val); 
            }
        }
        
        dfs(root.left, level+1);
        dfs(root.right, level+1); 
        
    }
    
    public List<Integer> largestValues(TreeNode root) {
        output = new ArrayList<>(); 
        if(root == null) return output; 
        dfs(root, 0); 
        return output;
    }
}