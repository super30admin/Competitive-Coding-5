// Time Complexity : O(9) = O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board.length > 9 || board[0].length == 0 || board[0].length > 9){
            return false;
        }
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'){
                    if(!valid(board, i, j, board[i][j])){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    private boolean valid(char[][] board, int row, int col, int num){
        for(int i=0; i<9; i++){
            if(i!= col && board[row][i] == num){
                return false;
            }
        }
        
        for(int i=0; i<9; i++){
            if(i != row && board[i][col] == num){
                return false;
            }
        }
        
        int x = row - row % 3; int y = col - col % 3;
        for(int i=x; i<x+3; i++){
            for(int j=y; j<y+3; j++){
                if(i!= row && j!= col && board[i][j] == num){
                    return false;
                }
            }
        }
        
        return true;
    }
}