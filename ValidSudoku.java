// Time Complexity :O(mxn)
// Space Complexity : O(9) = O(m)||O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I couldn't come up with for(int i=k/3*3; i<k/3*3+3; i++) and for(int j=k%3*3; j<k%3*3+3; j++)

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return true;
        
        int m = board.length;
        int n = board[0].length;
        
        //row
        for(int i=0; i<m; i++){
            int[] rows = new int[9];
            for(int j=0; j<n; j++){
                if(board[i][j] != '.'){
                    if(rows[Character.getNumericValue(board[i][j])-1] == 1)
                        return false;
                    else
                        rows[Character.getNumericValue(board[i][j])-1] = 1;
                }
            }
        }
        
        //col
        for(int j=0; j<n; j++){
            int[] cols = new int[9];
            for(int i=0; i<m; i++){
                if(board[i][j] != '.'){
                    if(cols[Character.getNumericValue(board[i][j])-1] == 1)
                        return false;
                    else
                        cols[Character.getNumericValue(board[i][j])-1] = 1;
                }
            }
        }
        
        //grid
        for(int k=0; k<m; k++)
        {
            int[] block = new int[9];
            for(int i=k/3*3; i<k/3*3+3; i++)
            {
                for(int j=k%3*3; j<k%3*3+3; j++)
                {
                    if(board[i][j] != '.'){
                        if(block[Character.getNumericValue(board[i][j])-1] == 1)
                            return false;
                        else
                            block[Character.getNumericValue(board[i][j])-1] = 1;
                    }
                }
            }
        }
        
        return true;
    }
}
