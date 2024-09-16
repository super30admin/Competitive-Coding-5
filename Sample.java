//https://leetcode.com/problems/find-largest-value-in-each-tree-row/
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

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
    List<Integer> list; // global result list
    public List<Integer> largestValues(TreeNode root) {
         list = new ArrayList<>(); 
        if(root == null) // if no root
            return list;
        
        dfs(root,0); // call dfs on root at level 0
        return list;
    }
    
    private void dfs(TreeNode root, int level)
    {
        //base
        if(root == null) // if root becomes null
            return;
        
        //logic
        if(list.size() == level) // if no value is there in list at the level
        {
            list.add(root.val); // add to list at the level
        }
        else
        {
            list.set(level, Math.max(root.val, list.get(level))); // get the value and update with curr value if it is max
        }
            
        dfs(root.left, level+1); //calling dfs on left
        dfs(root.right, level+1); //calling dfs on right
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None




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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // to store result
       if(root == null)  // if no root
           return list;
        int max; // to store max at each level
        Queue<TreeNode> q = new LinkedList<>(); // to process all nodes
        q.add(root); // adding root to queue
        
        while(!q.isEmpty()) // till queue is not empty
        {
            int size = q.size(); // size to maintain each level
            max = Integer.MIN_VALUE; // initializing max to min value for each level
            for(int i=0;i<size;i++) // looping through the level size
            {
                TreeNode curr = q.poll(); // getting curr node
                max = Math.max(max, curr.val); // updating max value
                if(curr.left!=null) // if left child exists add to queue
                    q.add(curr.left);
                if(curr.right!=null) // if right child exists add to queue
                    q.add(curr.right);
            }
            list.add(max); // add max for the level to the result
            
        }
        return list;
    }
}


// Time Complexity : O(1) as constant iterations
// Space Complexity : O(1) as constant space used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //edge case
        if(board==null|| board.length!=9 || board[0].length!=9)
            return false;

        //row
        for(int i=0;i<9;i++) // for each 9 row
        {
            boolean b[] = new boolean[9]; // create a boolean array
            for(int j=0;j<9;j++) // traverse through the 9 columns for each row
            {
                if(board[i][j]!= '.') // if value isnt empty
                {
                    if(b[(int)(board[i][j]-'1')]) // check if value is true at the index of boolean array
                    return false; // if true i.e already found a value at index earlier so return false
               b[(int)(board[i][j]-'1')] = true; // set the value at index to true
                }
                
            }
        }
        
        
         //column
        for(int j=0;j<9;j++) // for each 9 column
        {
            boolean b[] = new boolean[9]; // create a boolean array
            for(int i=0;i<9;i++) // traverse through the 9 columns for each row
            {
                 if(board[i][j]!= '.') // if value isnt empty
                {
                if(b[(int)(board[i][j]-'1')])  // check if value is true at the index of boolean array
                    return false; // if true i.e already found a value at index earlier so return false
                b[(int)(board[i][j]-'1')] = true; // set the value at index to true
                 }
            }
        }
        
        //block
        for(int block=0;block<9;block++) // to check for each 9 blocks
        {
             boolean b[] = new boolean[9]; // creating a boolean array for each block
           for(int i=block/3*3;i<block/3*3+3;i++) // finding row index for a single block
        { 
            for(int j=block%3*3;j<block%3*3+3;j++) // finding column index for a single block
            {
                 if(board[i][j]!= '.') // if value isnt empty
                {
                if(b[(int)(board[i][j]-'1')]) // check if value is true at the index of boolean array
                    return false; // if true i.e already found a value at index earlier so return false
                b[(int)(board[i][j]-'1')] = true; // set the value at index to true
                 }
            }
        }
        }
        return true; // if no false returned then return true
    }
}