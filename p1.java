https://leetcode.com/problems/valid-sudoku/description/

// Time Complexity : O(m*n)
// Space Complexity :O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach


class Solution {
    public  boolean isValidSudoku(char[][] board) {
        //check row
        for(int i=0; i<9; i++){
            boolean[] b = new boolean[9];
            for(int j=0; j<9; j++){
                if(board[i][j] != '.') {
                    if(b[board[i][j] - '1']) return false;
                    b[board[i][j] - '1'] = true;
                    }
            }
        }

        //check column
        for(int i=0; i<9; i++){
            boolean[] b = new boolean[9];
            for(int j=0; j<9; j++){
                if(board[j][i] != '.') {
                    if(b[board[j][i] - '1']) return false;
                    b[board[j][i] - '1'] = true;
                    }
            }
        }
        //check block
        for(int block = 0; block<9; block++){
            boolean[] b = new boolean[9];
            for(int i = block/3 * 3; i<block/3 * 3 + 3; i++){
                for(int j = block%3 * 3; j<block%3 * 3 + 3; j++){
                    if(board[i][j] != '.') {
                        if(b[board[i][j] - '1']) return false;
                        b[board[i][j] - '1'] = true;
                    }
                    
                }
            }
        }

        return true;
    }
}