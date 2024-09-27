// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //base case
        if(board==null)
            return true;
        //checking each row and each column
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]!='.' && !isValid(row, col, board)){
                    return false;
                }
            }
        }
        return true;
    }
    //checking if the each block, row and col in the given sudoku are valid or not
    private boolean isValid(int r, int c, char[][] board){
        //getting the blocks
        int rowB=r/3;
        int colB=c/3;
        //getting the start of row and col in those blocks
        int rowS= 3*rowB;
        int colS= 3*colB;
        //initializing a variable to store the value in the row and col 
        char currentV=board[r][c];
        //checking for each block
        for(int i=rowS; i<rowS+3;i++){
            for(int j=colS;j<colS+3;j++){
                //checking the following condition. if statisfy return false
                if(i<9 && j<9 && board[i][j]==currentV && i!=r && j!=c){
                    return false;
                }
            }
        }
        //checking for each row
        for(int i=0; i<9; i++){
            if(board[r][i]==currentV && i!=c){
                return false;
            }
        }
        //checking for each col
        for(int i=0; i<9; i++){
            if(board[i][c]==currentV && i!=r){
                return false;
            }
        }
        return true;
    }
}