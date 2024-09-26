//Problem 71: Find Largest Value in Each Tree Row 
// Time Complexity : O(N), number of elements in tree
// Space Complexity : O(H), considering recursive stack | O(N/2)=>O(N) for BFS 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
  Steps: BFS: Insert element in the queue. Use size variable to differentiate between the levels and max variable for finding max value at each level. Compare the polled nodes with max and at the end of level insert max in the resultant list.
         DFS: Pass level(index) starting 0 and increment it at each recursive call. If level==size of the resultant list then add the root val in the list, otherwise just update(set) the value in the resultant list at that level(index) if current value is greater than the existing value in the list.  
*/


import java.util.*;

class Solution71 {

   class TreeNode {
       int val;
       TreeNode left, right;
       TreeNode(int val){
           this.val = val;
       }
    }

    private List<Integer> res;
   public List<Integer> largestValues(TreeNode root) {
         
          //initialise output
          res = new ArrayList<>();
 
          //edge
          if(root==null) return res;
 
          //function for calc max element
          //helperDFS(root,0);
 
          helperBFS(root);
       
         return res;
   }
 
   private void helperDFS(TreeNode root, int level){
 
      //base
       if(root == null) return;
 
      //logic
      if(res.size()==level){
          res.add(level,root.val);  
      }else{
           if(res.get(level)<root.val){
              res.set(level,root.val);
           }
      }
     
      helperDFS(root.left,level+1);
      helperDFS(root.right,level+1);
 
   }
     
   private void helperBFS(TreeNode root){
       
       Queue<TreeNode> q = new LinkedList<>();
       q.offer(root);
       
       while(!q.isEmpty()){
           int size = q.size();
           int max = Integer.MIN_VALUE;
           
           for(int i=0;i<size;i++){
               TreeNode curr = q.poll();
               max = Math.max(max,curr.val);
               
               if(curr.left!=null) q.offer(curr.left);
               if(curr.right!=null) q.offer(curr.right);
               
           }
           
           res.add(max);
       }
       
   }  
     
 }