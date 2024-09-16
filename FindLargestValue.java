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

//BFS approach
class Solution {

    // Time Complexity : 0(n) where n is the no. of nodes
// Space Complexity : 0(n) where n is the no of nodes
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>(); //declaring a queue to run bfs and store each and every node visited
        List <Integer> result = new ArrayList<>();  //for final output
        q.add(root);    //adding the root from where the traversal starts
        while(!q.isEmpty()){
            int max = Integer.MIN_VALUE;    //declaring a max value inside while loop as at each level, the value has to be set to default
            int size = q.size();        //calculating size to figure out at which level we are and to get the max of each level
            for(int i = 0; i < size; i++){  //running for loop for the size of the queue
                TreeNode temp = q.remove();     //removing an element from queue to check if it is greater than max or not
                if(temp.val > max){
                    max = temp.val;
                }
                if(temp.left != null){      //checking if it has left and right child or not
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
            result.add(max);        //storing the max at each level
        }
        return result;      //returining result
    }
}