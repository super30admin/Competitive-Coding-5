    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/valid-sudoku/
    Time Complexity for operators : o(n*n) .. two for loops
    Extra Space Complexity for operators : o(3n) ... used boolean array 3 times.
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 

        # Optimized approach: 
                              
            Approach   
                    A. Check for the each row and add (make true) every element into boolean array. 
                       if something repeasted then return  false else true.
                    B. Check for the each column and add (make true) every element into boolean array. 
                       if something repeasted then return  false else true.
                    C. Check for the each block and add (make true) every element into boolean array. 
                       if something repeasted then return  false else true.

       */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        
        // row
        for(int i=0;i<board.length;i++){
            boolean b[] = new boolean[9];    
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    if(b[(board[i][j]-'1')]) return false;
                    b[(board[i][j]-'1')] = true;
                }
            }
        }
        
        
        //column
        for(int j=0;j<board.length;j++){
            boolean b[] = new boolean[9];    
            for(int i=0;i<board[0].length;i++){
                if(board[i][j]!='.'){
                    if(b[(board[i][j]-'1')]) return false;
                    b[(board[i][j]-'1')] = true;
                }
            }
        }
        
        for(int block = 0;block<9;block++){
            boolean b[] = new boolean[9];    

            for(int i=block/3*3;i<block/3*3+3;i++){
            for(int j=block%3*3;j<block%3*3+3;j++){
                if(board[i][j]!='.'){
                    if(b[(board[i][j]-'1')]) return false;
                    b[(board[i][j]-'1')] = true;
                }
            }
        }
        }
        return true;
    }
    
    
}