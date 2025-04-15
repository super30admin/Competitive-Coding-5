
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



/*
This program finds the largest value in each row of a binary tree using a level-by-level traversal.
 It maintains a queue to process nodes at each level, updating the maximum value encountered
 before moving to the next. Once a level is completed, the maximum is added to the result list.
 The program runs in O(n) time and uses O(l) space, where n is the number of nodes and l is
 the number of leaf nodes.
The space is dominated by the queue, which holds the nodes of the largest level at any time.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LargestValueTreeRow {
    public List<Integer> largestValues(TreeNode root) {

        //feedback for mock
        //try writing time and space in comments
        //also once optimized version is done
        //
        List<Integer> ans=new ArrayList<>();

        if(root==null)
            return ans;

        Queue<TreeNode> queue=new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty())
        {
            int size=queue.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++)
            {
                TreeNode curr=queue.poll();
                if(max<curr.val)
                    max=curr.val;

                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
            }
            ans.add(max);
        }

        return ans;
    }

}

   class TreeNode {
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