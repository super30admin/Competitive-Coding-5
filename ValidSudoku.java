// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// For each value in input matrix, perform row level, column level and box level validations
public class ValidSudoku{
    public boolean validSudoku(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]!='.')
                    return isValid(board,i,j);
            }
        }
        return  true;
    }

    private boolean isValid(char[][] board, int i, int j){
        char val = board[i][j];

        //check row
        for(int k=0;k<9;k++){
            if(board[k][j]==val && k!=i)
                return false;
        }
        //check col

        //check box
        return true;
    }
}