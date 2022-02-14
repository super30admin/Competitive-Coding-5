// Time Complexity : O(n^3)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// for row and col validate the boolean array of size 9 and check if found true return false. for block, 3 loop : 1) loop from 0 -9 blocks 2) i = blk/3*3 to blk/3*3+3 3) j = blk%3*3 to blk%3*3
// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length < 9
           || board[0].length < 9 ) return false;
        // row
        for(int i = 0; i < 9; i++){
            boolean [] b = new boolean[9];
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(b[(int)board[i][j]-'1']) return false;
                    b[(int)board[i][j]-'1'] = true;
                }
            }
        }
        // column
        for(int j = 0; j < 9; j++){
            boolean [] b = new boolean[9];
            for(int i = 0; i < 9; i++){
                if(board[i][j] != '.'){
                    if(b[(int)board[i][j]-'1']) return false;
                    b[(int)board[i][j]-'1'] = true;
                }
            }
        }
        // block
        for(int blk = 0; blk < 9; blk++){
            boolean [] b = new boolean[9];
            for(int i = blk/3*3; i < blk/3*3+3; i++){
                for(int j = blk%3*3; j < blk%3*3+3; j++){
                    if(board[i][j] != '.'){
                         if(b[(int)board[i][j]-'1']) return false;
                         b[(int)board[i][j]-'1'] = true;
                    }
                }
            }
        }
        return true;
    }
}
