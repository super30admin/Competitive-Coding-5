// There are two approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

// Your code here along with comments explaining your approach
// Approach 1: Using BFS
// Time Complexity : O(n)
//      n: number of nodes
// Space Complexity : O(n/2) = O(n)
//      n: number of nodes
//      Since it is a binary tree
class Problem1S1 {

    /**Definition for a binary tree node.*/
    class TreeNode {

        // member variable
        int val;
        // referneces
        TreeNode left;
        TreeNode right;

        // default constructor
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /** find larger value on each level */
    public List<Integer> largestValues(TreeNode root) {
        // result
        List<Integer> result = new ArrayList<>();

        // edge case
        if(root!= null){

            // for processing in FIFO
            Queue<TreeNode> myQueue = new LinkedList<>();
            myQueue.add(root);
            
            // level by level
            while(!myQueue.isEmpty()){
                
                // level
                int size = myQueue.size();
                // max at each level
                int maxVal = Integer.MIN_VALUE;
                while(size != 0){
                    // process 
                    TreeNode current = myQueue.poll();
                    // check current
                    if(current.val > maxVal)
                        maxVal = current.val;

                    // add left and right
                    if(current.left != null)
                        myQueue.add(current.left);
                    if(current.right != null)
                        myQueue.add(current.right);
                    
                    size--;
                }
                // add max to result
                result.add(maxVal);
            } 
            
        }
        return result;
    }
}

// Your code here along with comments explaining your approach
// Approach 2: Using DFS
// Time Complexity : O(n)
//      n: number of nodes
// Space Complexity : O(h) = O(log n)
//      h: height of the tree
//   Recursive stack and binary tree
class Problem1S2 {

    /**Definition for a binary tree node.*/
    class TreeNode {

        // member variable
        int val;
        // referneces
        TreeNode left;
        TreeNode right;

        // default constructor
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // global result
    List<Integer> result;

    /** find larger value on each level */
    public List<Integer> largestValues(TreeNode root) {
        // result
        result = new ArrayList<>();
        // do dfs
        depthFirst(root, 0);
        return result;
    }
    
    private void depthFirst(TreeNode root, int level){       
        // base case
        if(root!= null){

            // result has not reached that level
            if(result.size() == level)
                result.add(Integer.MIN_VALUE);

            // check with current max and take max
            if(root.val > result.get(level))
                result.set(level, root.val);

            //increase level
            level++;
            // go left and right
            depthFirst(root.left, level);
            depthFirst(root.right, level);
        }
    }
}