package Nov15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
class LargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {

/*
       
     Time Complexity: O(n)
    Because we are iterating over all the tree nodes levelwise to find max element for each level.
    
     Space Complexity: O(n/2)
     At max, BFS queue will have n/2 leaf nodes when last level of the tree will be processed.
   
     Did this code successfully run on Leetcode : Yes
    
     Any problem you faced while coding this : No
     
     Approach: BFS tree traversal.
       
*/
        
        List<Integer> result = new ArrayList<>();
      
        // edge conditions
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        // maintain max value for each level using BFS traversal. 
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            int max = Integer.MIN_VALUE;
           // Once a level is processed completely(queueSize has been iterated completely), add the max value found for the processed level to result list.
            for (int i = 0; i < qSize; i++) {
                TreeNode curElem = queue.poll();
                if (curElem.val > max) {
                    max = curElem.val;
                }
                if (curElem.left != null) {
                    queue.add(curElem.left);
                }
                 if (curElem.right != null) {
                    queue.add(curElem.right);
                }
            }
            result.add(max);
        }
        
        return result;
        
    }
}