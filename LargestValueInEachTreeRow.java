// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/**
//Here we are going to do a bfs approach
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
      
      //sanity check
      //queue root
      //bfs and get max
      //add left and right to the queue
      //return result
      
      List<Integer> result = new ArrayList<>();
      //check if the root node itself is null then return the empty list
      if(root == null)
      {
        return result;
      }
      //add the first node to the queue
      Queue<TreeNode> queue = new LinkedList<>(); //1,2,3
      queue.add(root);                            //1
      //bfs traversal
      while(!queue.isEmpty())
      {
        int size = queue.size();                  //2,3
        //initilise the max variable at every level
        int max = Integer.MIN_VALUE;
        for(int i=0;i<size;i++)
        {
          TreeNode front = queue.poll();          //3
          int current = front.val;                //3
          //update the max
          if(current>max)
          {
            max = current;                      //3
          }
          //check for left child
          if(front.left!=null)
          {
            queue.add(front.left);               //2
          }
          //check for right child
          if(front.right!=null)
          {
            queue.add(front.right);           //3
          }
        }
        result.add(max);                      //{1,3}
             
      }
       return result; 
    }
}


// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/**
//Here we are going to do a dfs appraoch.


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
      //dfs function for the recursive stack
      dfs(root,0);
      return result;
    }
  
  private void dfs(TreeNode node,int level)
  {
  	//no more node to add to the stack
    if(node==null)
    {
      return;
    }
    //keep on checking the left children
    if(result.size()<level+1)
    {
      result.add(node.val);
    }
    //go back to a certain level and compare the max at that level
    else
    {
      result.set(level,Math.max(result.get(level),node.val));
    }
    //recrusive call for left child
    dfs(node.left,level+1);
        //recrusive call for right child

    dfs(node.right,level+1);
  }
}