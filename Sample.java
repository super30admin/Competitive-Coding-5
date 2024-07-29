//problem 1
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen=new HashSet<>();
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')
                {
                    if(!seen.add(board[i][j]+"row"+i)||!seen.add(board[i][j]+"col"+j)||!seen.add(board[i][j]+ "box" + i/3 + "-" + j/3))
                    {
                        return false;
                    }
                  
                }
            }
        }
        return true;
    }
}

//problem 2
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

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
    List<Integer> result= new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root ==null) return new ArrayList<>();
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int lvl)
    {
        // base
        if(root==null) return;
       
        if(result.size()==lvl)
        {
            result.add(root.val);
        }
        else{
        
            result.set(lvl,Math.max(result.get(lvl),root.val));
        }
        //recursion
        dfs(root.left,lvl+1);
        dfs(root.right,lvl+1);
    }
}