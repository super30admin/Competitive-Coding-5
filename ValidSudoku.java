// Time Complexity : O(N^3)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Loop through the grid,
1. validate all columns, for a given row,
2. validate all rows, for a given col
3. for a given 3*3 subgrid --> subrow= 3(row/3) and subcol= 3(col/3) move 3 subblocks at time
*/
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length==0) return true;

        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(board[row][col]=='.') continue;
                if(!isRowValid(board,row,col) || !isColValid(board,row,col) || !isBlockValid(board,row,col)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isRowValid(char[][] board, int currRow, int currCol){
        for(int col=currCol+1;col<board[0].length;col++){
            if((board[currRow][col]==board[currRow][currCol])) {
                return false;
            }
        }

        return true;
    }

    private boolean isColValid(char[][] board, int currRow, int currCol){
        for(int row=currRow+1;row<board.length;row++){
            if((board[row][currCol]==board[currRow][currCol])) {
                return false;
            }
        }

        return true;
    }

    private boolean isBlockValid(char[][] board, int r, int c){
        int ri= 3*(r/3);
        int ci= 3*(c/3);

        for(int i=ri;i<ri+3;i++){
            for(int j=ci;j<ci+3;j++){
                if(i!=r && j!=c && board[i][j]==board[r][c]) return false;
            }
        }

        return true;
    }
}
