// Time Complexity : O(1)-> O(81)
// Space Complexity : O(1)-> O(81)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
 

// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length ==0 ) return true;
        // row
        for(int i =0; i<9;i++)
        {
            boolean[] b = new boolean[9];
            for(int j =0; j<9;j++)
            {
                if(board[i][j]!='.'){
                    if(b[(int)(board[i][j]-'1')]) return false;
                   b[(int)(board[i][j]-'1')] = true;
                }
            }
        }

        //col
        for(int j =0; j<9;j++)
        {
            boolean[] b = new boolean[9];      // traverse along the col and see if the number exists 
            for(int i =0; i<9;i++)
            {
                if(board[i][j]!='.'){
                    if(b[(int)(board[i][j]-'1')]) return false;   // number already exists return false
                   b[(int)(board[i][j]-'1')] = true; // if encountering first time put true at its index
                }
            }
        }

        //grid

        for(int grid =0 ;grid <9 ; grid++)
        {
            boolean[] b = new boolean[9];
            // traverse the nine 3*3 grids
            for(int i = grid/3 *3; i<grid/3 *3+3;i++)   // row at max 3 rows
        {
            
            for(int j =grid%3 *3; j<grid%3 *3+3;j++)  // col at max 3 cols 
            {
                if(board[i][j]!='.'){
                    if(b[(int)(board[i][j]-'1')]) return false;
                   b[(int)(board[i][j]-'1')] = true;
                }
            }
        }
        }
     return true;
        
    }
}
