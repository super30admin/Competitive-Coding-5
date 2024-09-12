// Time Complexity : O(1) since input is constant
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length!=9|| board[0].length!=9) return false;
        for(int i =0 ; i<9 ; i++){
            boolean[] arr = new boolean[9];
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    if(arr[(int)board[i][j]-'1'] == true) return false;
                    arr[(int)board[i][j]-'1'] = true;
                }
            }
        }
        
        for(int i =0 ; i<9 ; i++){
            boolean[] arr = new boolean[9];
            for(int j=0; j<9; j++){
                if(board[j][i] != '.'){
                    if(arr[(int)board[j][i]-'1'] == true) return false;
                    arr[(int)board[j][i]-'1'] = true; 
                }
            }
        }
        
        for(int k=0; k<9 ; k++){
           boolean[] arr = new boolean[9];
            for(int i = k/3*3 ; i< k/3*3+3 ; i++){
                for(int j= k%3*3; j< k%3*3+3; j++){
                    if(board[i][j] != '.'){
                        if(arr[(int)board[i][j]-'1'] == true) return false;
                        arr[(int)board[i][j]-'1'] = true; 
                    }
                }
            }
        }
        return true;
    }
}