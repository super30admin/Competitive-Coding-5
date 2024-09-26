// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Level order traversal
class Solution {
    
     public List<Integer> largestValues(TreeNode root) {
         List<Integer> res = new ArrayList<>();
         if(root == null)
             return res;
         
         Queue<TreeNode> q = new LinkedList<>();
         q.add(root);
         int max=0;
         
         while(!q.isEmpty()){ 
             int size = q.size();
             max = Integer.MIN_VALUE;
             for(int i=0; i<size; i++){
                 TreeNode front = q.remove();
                 
                 max = Math.max(max, front.val);
                 if(front.left != null){
                     q.add(front.left);
                 }
                 if(front.right != null){
                     q.add(front.right);
                 }
             }
             res.add(max);   
         }         
         return res;
    }
    
    
   
}