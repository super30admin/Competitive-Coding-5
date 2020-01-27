// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){			// base case 
            return new ArrayList<>();
        }
        
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){		// process through all the levels 
            int size = q.size();		// size to traverse only through the particular level
            int largest = Integer.MIN_VALUE;	// set the largest to min before starting every level
            
            for(int i = 0; i < size; i++){		// traverse through all the elements in the level 
                TreeNode temp = q.poll();		// Using FIFO, process all the nodes from left to right
                
                if(largest < temp.val){			// compare all the elements and update the largest value
                    largest = temp.val;
                }
                if(temp.left != null){			// add the left child
                    q.add(temp.left);
                }
                if(temp.right != null){			// add the right child
                    q.add(temp.right);
                }
            }
            
            result.add(largest);				// once the level is traversed completely, add the largest to the result list.
        }
        
        return result;
    }
}