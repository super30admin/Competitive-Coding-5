// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Valid soduku 
// Time complexity - O(n*n*n) where n is the row or col or no of boxes of a square board
// Space complexity - O(n) - aux boolean array
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0){
            return true;
        }
        // row
        for(int i = 0; i < 9; i++){
            boolean[] b = new boolean[9];
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(b[board[i][j] - '1'] == true)
                        return false;
                    b[board[i][j] - '1'] = true;
                }
            }
        }
        
        //column
        for(int j = 0; j < 9; j++){
            boolean[] b = new boolean[9];
            for(int i = 0; i < 9; i++){
                if(board[i][j] != '.'){
                    if(b[board[i][j] - '1'] == true)
                        return false;
                    b[board[i][j] - '1'] = true;
                }
            }
        }
        
        //box
        for(int box = 0; box < 9; box++){
            boolean[] b = new boolean[9];
            for(int i = box / 3 * 3; i < box / 3 * 3 + 3; i++){
                for(int j = box % 3 * 3; j < box % 3 * 3 + 3; j++){
                    if(board[i][j] != '.'){
                        if(b[board[i][j] - '1'] == true)
                            return false;
                        b[board[i][j] - '1'] = true;
                    }
                }
            }
        }
        
        return true;
        
    }
}