class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int boxRow = i - i%3;
                int boxCol = j - j %3;
                if(board[i][j] == '.'){
                    continue;
                }
                
                if(!check(board, i, j, boxRow, boxCol)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean check(char[][] board, int r, int c, int boxRow, int boxCol){
        int row = r;
        int col = c;
        // To check row doesnot contain same number
        while(row >= 0){
            if(r != row && board[row][col] == board[r][c]){
                return false;
            }
            row--;
        }
        row = r;
        while(row < board.length){
            if(r != row && board[row][col] == board[r][c]){
                return false;
            }
            row++;
        }
        
        row = r;
        // To check col doesnot contain same number
        while(col >= 0){
            if(c != col && board[row][col] == board[r][c]){
                return false;
            }
            col--;
        }
        col = c;
        while(col < board[0].length){
            if(c != col && board[row][col] == board[r][c]){
                return false;
            }
            col++;
        }

        //to check the box doesnot contain same number
        for(int i = boxRow; i <= boxRow+2; i++){
            for(int j = boxCol; j <= boxCol+2; j++){
                if(r != i && c != j){
                    if(board[i][j] == board[r][c]){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}

//Time Complexity: O(n*n) 
//Space Complexity: O(1)