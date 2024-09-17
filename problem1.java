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
//iterative approach
//Time- O(N)
//space- O(N)
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);    
        if(root==null) return res;
        while(!q.isEmpty()){
          int max=Integer.MIN_VALUE;
               int size= q.size();        
            for(int i=0; i<size; i++){
              TreeNode node= q.poll(); 
              //  if(max==null) max=node.val;
                if(max<node.val) max=node.val;            
                if(node.left!=null)
                q.add(node.left);               
                if(node.right!=null)
                q.add(node.right);                
            }        
            res.add(max);
        }
        return res;
        
    }
}