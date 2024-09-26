// Valid Sudoku

// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9)
            return false;
        
        //row
        for(int i = 0; i < 9; i++){
            boolean[] row = new boolean[9];
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int num = Integer.parseInt(String.valueOf(board[i][j]));
                    if(row[num - 1]) //index starts from 0, so subtract 1 from num
                        return false;
                    row[num - 1] = true;
                }
            }
        }

        //column
        for(int j = 0; j < 9; j++){
            boolean[] column = new boolean[9];
            for(int i = 0; i < 9; i++){
                if(board[i][j] != '.'){
                    int num = Integer.parseInt(String.valueOf(board[i][j]));
                    if(column[num - 1])
                        return false;
                    column[num - 1] = true;
                }
            }
        }

        //block
        for(int block = 0; block < 9; block++){
            boolean[] b = new boolean[9];
            for(int i = block/3*3; i < block/3*3+3; i++){
                for(int j = block%3*3; j < block%3*3+3; j++){
                    if(board[i][j] != '.'){
                        int num = Integer.parseInt(String.valueOf(board[i][j]));
                        if(b[num - 1])
                            return false;
                        b[num - 1] = true;
                    }
                }
            }
        }
        return true;
    }
}