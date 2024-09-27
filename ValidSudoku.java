//Time Complexity: O(1)  ( A sudoku's dimensions are always constant)
//Space Complexity: O(1) ( A sudoku's dimensions are always constant)
//Did this code successfully run on Leetcode : Yes                        
                      
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9)
            return false;
        //check whether rows have repitition or not
        for(int i=0; i<9; i++) {
            boolean[] row = new boolean[9];
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') {
                    if(row[board[i][j]-'1']) return false; 
                    row[board[i][j]-'1'] = true;
                }
            }
        }
        //check whether columns have repitition or not
        for(int j=0; j<9; j++) {
            boolean[] col = new boolean[9];
            for(int i=0; i<9; i++) {
                if(board[i][j] != '.') {
                    if(col[board[i][j]-'1']) return false; 
                    col[board[i][j]-'1'] = true;
                }
            }
        }
        //check whether 3 x 3 sub-boxes have repitition or not
        for(int block=0; block<9; block++) {
            boolean[] box = new boolean[9];
            for(int i=block/3*3; i<block/3*3+3; i++) {
                for(int j=block%3*3; j<block%3*3+3; j++) {
                    if(board[i][j] != '.') {
                        if(box[(board[i][j])-'1']) return false; 
                        box[board[i][j]-'1'] = true;
                    }
                }
            }
        }
        return true;
    }
}