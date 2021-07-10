// Time Complexity : O(n * n)
// Space Complexity : O(1)

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9)
            return false;
        //row
        for(int i = 0; i < 9; i++){
            boolean[] b = new boolean[9];
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(b[(int)board[i][j] - '1'])
                        return false;
                    b[(int)board[i][j] - '1'] = true;
                }
            }   
        }
        
        //column
        for(int j = 0; j < 9; j++){
            boolean[] b = new boolean[9];
            for(int i = 0; i < 9; i++){
                if(board[i][j] != '.'){
                    if(b[(int)board[i][j] - '1'])
                        return false;
                    b[(int)board[i][j] - '1'] = true;
                }
            }   
        }
        
        //block
        for(int k = 0; k < 9; k++){
            boolean[] b = new boolean[9];
            for(int i = k / 3 * 3; i < k / 3 * 3 + 3; i++){
                for(int j = k % 3 * 3; j < k % 3 * 3 + 3; j++){
                    if(board[i][j] != '.'){
                        if(b[(int)(board[i][j] - '1')])
                            return false;
                        b[(int)board[i][j] - '1'] = true;
                    }
                }   
            }
        }
        
        return true;
    }
}