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

// Time Complexity : O(N)
// Space Complexity : O(h) h is height of recursive stack
// Did this code successfully run on Leetcode : Yes

class Solution {
      public List<Integer> largestValues(TreeNode root) {
          List<Integer> result = new ArrayList<>();
          if(root == null)
              return result;
          dfs(root, result,  0);
          
          return result;
      }
      private void dfs(TreeNode root, List<Integer> res, int d){
          if(root == null)
              return;
          
            if(d == res.size()){
                res.add(root.val);
            }
            else{
                res.set(d, Math.max(res.get(d), root.val));
            }
          dfs(root.left, res, d+1);
          dfs(root.right, res, d+1);
      }
}


/*
// bfs solution
// Time Complexity : O(N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes

class Solution {
      public List<Integer> largestValues(TreeNode root) {
          List<Integer> result = new ArrayList<>();
          if(root == null)
              return result;
          Queue<TreeNode> q = new LinkedList<>();
          q.add(root);
          int rindex = 0;
          while(!q.isEmpty()){
              int size = q.size();
              int max = Integer.MIN_VALUE;
              for(int i=0; i<size; i++){
                  TreeNode temp = q.poll();
                  max = Math.max(temp.val, max);
                  if(temp.left != null)
                      q.add(temp.left);
                  if(temp.right != null)
                      q.add(temp.right);
              }
              result.add(rindex, max);
              rindex++;
          }
          return result;
      }
}
*/