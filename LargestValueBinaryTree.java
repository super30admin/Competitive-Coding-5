import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// * Definition for a binary tree node.
  public class LargestValueBinaryTree {
	  
	  class TreeNode{
  
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
	  }
 
class Solution {
    
    public List<Integer> largestValues(TreeNode root) {
  
        List <Integer> ans = new ArrayList<>();
        Queue <TreeNode> q = new LinkedList<>();
        
        //base
        if(root == null) return ans;
        q.add(root);
         
        while(!q.isEmpty()){
            int largest = Integer.MIN_VALUE;
            int size = q.size();
            for(int i=0 ; i < size ; i++){
                
                TreeNode curr = q.poll();
                
                 largest =   Math.max(largest, curr.val);
                
                
                if(curr.left != null) {
                    q.add(curr.left);
                }
                   if(curr.right != null) {
                    q.add(curr.right);
                }
            }
           ans.add(largest);

        }
        return ans;
    }
}
}