//TC:O(n)
//SC:O(n)
//Microsoft 
//Iterative Solution:
//There is iterative solution as well i.e. we will be storing all the values of every level in the queue then we will be finding the largest of all the values for every level and then we will proceed the same .This is iterative approach


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
   public List<Integer> largestValues(TreeNode root) {
       List<Integer> result = new ArrayList<>();
       Queue<TreeNode> q = new LinkedList<>();
       if(root==null) return result;
       q.add(root);
      
       while(!q.isEmpty()){
           Integer max = null;
           int size = q.size();
           for(int i=0;i<size;i++){
               TreeNode node = q.poll();
               
               if(max==null)
                   max=node.val;
              
               if(max<node.val)
                   max=node.val;

               if(node.left!=null)
                   q.add(node.left);

               if(node.right!=null)
                   q.add(node.right);
           }
           result.add(max);
       }
       return result;
   }
}
  