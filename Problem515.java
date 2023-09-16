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
//DFS
// Time Complexity : O(n) --> no.of nodes
// Space Complexity : O(h) --> stack recurssion
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    List<Integer> result;
    public List<Integer> largestValues(TreeNode root) {
        this.result = new ArrayList<>();

        helper(root,0);
        return result;

    }
  public void  helper(TreeNode root, int depth){
      //base case
      if(root == null) return;

      //logic
      int size = result.size();
      if(size==depth)
      result.add(root.val);   // at every level add the first encountered element into list to handle left subtree
      if(size>depth){
      if(result.get(depth)<root.val)
        result.set(depth, root.val);   //  if max element is at right subtree at same level replace it
      }
      helper(root.left, depth+1);     // recurse on left and right
      helper(root.right, depth+1);


 }
}

 // BFS
 // Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
 class Solution {
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer>  result = new ArrayList<>();
        if(root ==null) return result;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        
        while(!queue.isEmpty()) 
        {
            int size = queue.size();   // elements in each level
            int max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++)  // iterate through the each level
            {
                TreeNode curr = queue.poll(); 
                max = Math.max(max, curr.val); // take max value
                if(curr.left!= null) queue.add(curr.left);
                if(curr.right!= null) queue.add(curr.right);   // add left and right children if they are not null
            }
            result.add(max); // add max element at each level to list
        }

    return result;
    }
}