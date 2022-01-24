// Time Complexity : O(n*n); where n = 9
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // intialize the rows,columns and boxes matrix
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxes = new int[9][9];
        
        // traverse the board matrix 
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){

                // if element is ., then continue
                if(board[r][c] == '.'){
                    continue;
                }
                
                // convert character to int
                int number = board[r][c] - '1';

                // check whether number is already present in the rows matrix
                if(rows[r][number] == 1){
                    // if present return false
                    return false;
                }
                // if number is not present, then update the index to 1
                rows[r][number] = 1;

                // check whether number is already present in the cols matrix
                if(cols[c][number] == 1){
                    // if present return false
                    return false;
                }
                // if number is not present, then update the index to 1
                cols[c][number] = 1;

                // find the box number with given row r and col c 
                int box = (r/3)*3 + (c/3);
                // check whether number is already present in the box
                if(boxes[box][number] == 1){
                    // if present return false
                    return false;
                }
                // if number is not present, then update the index to 1
                boxes[box][number] = 1;
            }
        }
        return true;
    }
}