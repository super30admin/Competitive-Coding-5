// Time Complexity : O(N^(m^3)) ~= O(N) where m is 9 in this case
//                      as for each element we have to check block, row and col
// Space Complexity : O(1) no extra space as it is being verfied in the given matrix
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null)
            return true;

        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){

               if(board[row][col] != '.' && !isValid(row,col,board)){
                   return false;
               }
            }
        }

        return true;

    }

    private boolean isValid(int r, int c, char[][] board){


        int rblock = (r)/3;
        int cblock = (c)/3;

        int rowStart = 3 * rblock;
        int colStart = 3 * cblock;

        char curr = board[r][c];

        //block
        for(int  i = rowStart; i < rowStart+3; i++){
            for(int j = colStart; j < colStart+3; j++){
                if( i < 9 && j < 9 && board[i][j] == curr && i != r && j != c){
                    return false;
                }
            }
        }

        // in that row
         for(int  i = 0 ; i < 9; i++){
            if(board[r][i] == curr && i != c){
                    return false;
                }
         }


        //col
        for(int  i = 0 ; i < 9; i++){
            if(board[i][c] == curr && i != r){
                    return false;
                }
         }

        return true;

    }
}
