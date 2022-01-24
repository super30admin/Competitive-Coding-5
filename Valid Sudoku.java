// Time Complexity : O(n*n); where n = 9
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxes = new int[9][9];
        
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                if(board[r][c] == '.'){
                    continue;
                }
                
                int number = board[r][c] - '1';

                if(rows[r][number] == 1){
                    return false;
                }
                rows[r][number] = 1;

                if(cols[c][number] == 1){
                    return false;
                }
                cols[c][number] = 1;

                int box = (r/3)*3 + (c/3);
                if(boxes[box][number] == 1){
                    return false;
                }
                boxes[box][number] = 1;
            }
        }
        return true;
    }
}