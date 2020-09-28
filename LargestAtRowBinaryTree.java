/*
 * #515. Find Largest Value in Each Tree Row
 * 
 * Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).


Example 1:
Refer leetcode for diagram

Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]

Example 2:

Input: root = [1,2,3]
Output: [1,3]

Example 3:

Input: root = [1]
Output: [1]

Example 4:

Input: root = [1,null,2]
Output: [1,2]

Example 5:

Input: root = []
Output: []
 

Constraints:

1. The number of nodes in the tree will be in the range [0, 104].
2. -231 <= Node.val <= 231 - 1

 */


/*
 * Time Complexity: O (N) -> We are visiting all the nodes at each level/row in a binary tree one by one
 * 
 * Space Complexity: O (N) -> A queue stores 'N' nodes at current level, not all nodes of a binary tree at the same time
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.competitivecoding5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Definition for a binary tree node.
class TreeNode11 {
	     int val;
	     TreeNode11 left;
	     TreeNode11 right;
	     TreeNode11() {}
	     TreeNode11(int val) { this.val = val; }
	     TreeNode11(int val, TreeNode11 left, TreeNode11 right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	     }
	 }


public class LargestAtRowBinaryTree {
	public List<Integer> largestValues(TreeNode11 root) {
        
        List<Integer> output = new ArrayList<>();
        
        // #1. Base condition 
        if(root == null){
            return output;
        }
        
        // #2. Create a queue using LinkedList to store nodes of a binary tree
        Queue<TreeNode11> queue = new LinkedList<TreeNode11>();
        
        // #3. Initiate a queue with root node
        queue.add(root);
        
        // #4. Start the BFS level order traversal
        while(!queue.isEmpty()){
            
            // Get the size of a queue at current level
            int levelLen = queue.size();
            // Initialize the largest value at each level/row since we need to find largest value at each row and not of entire binary tree
            int largest = Integer.MIN_VALUE;
            
            // for loop runs for all the elements at each current level/row
            for(int i = 0; i < levelLen; i++){
                // Remove the front from queue
                TreeNode11 front = queue.poll();
                
                // Check if front element is greater than value in largest
                // If yes, change the largest value to front element
                if(front.val > largest){
                    largest = front.val;
                }
                
                // To traverse to the next level/row, we need to add left and right child of each node at current level to the queue
                if(front.left != null){
                    queue.add(front.left);
                }
                
                if(front.right != null){
                    queue.add(front.right);
                }
                
            }
            // After traversing through elements of a current level, add the largest element of that level to an output list
            output.add(largest);
        }
        
        // #5. return the list of largest numbers at each level/row of a binary tree
        return output;
        
    }

}
