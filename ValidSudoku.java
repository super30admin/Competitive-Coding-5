// TC - O(1), SC - O(1)
// LC - 36
class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        if(board == null || board.length == 0){
            return true;
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(!check(board, i, j)){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean check(char[][] board, int row, int col){
        
        //check row
        for(int i=0; i<board[0].length; i++){
            if(i != col && board[row][i] == board[row][col]){
                return false;
            }
        }
        
        
        //check column
        for(int i=0; i<board.length; i++){
            if(i != row && board[i][col] == board[row][col]){
                return false;
            }
        }
        
        //check box
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        
        for(int i=boxRow; i<boxRow+3; i++){
            for(int j=boxCol; j<boxCol+3; j++){
                if(i != row && j != col && board[i][j] == board[row][col]){
                    return false;
                }
            }
        }
        return true;
    }
}