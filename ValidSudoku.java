// Time Complexity : O(n) where n is the number of elements in the matrix
// Space Complexity : O(3n) as we are maintaining auxilary row, column and occur as seen matrices of the same size as the original matrix
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Assignment to the matrices in current way.
/* Your code here along with comments explaining your approach: Parse through the Sudoku matrix, as you see a number assign it to the correct matrix
to mark it as seen. Row matrix covers seen in the particular row. Column matrix covers seen in the particular column. Occur matrix covers seen in the particular
grid. Assign the number as the index in all the three matrices as a seen number. if the number occurs again, there would be a conflict as we are assinging
the numbers as per indices.
*/

// Use 2d arrays as seen matrices 
class Solution {
    public boolean isValidSudoku(char[][] board) {
    if(board == null || board.length == 0){return false;}
    boolean[][] row = new boolean[9][9];                                                // Number seen in the row
    boolean[][] col = new boolean[9][9];                                                // Number seen in the column
    boolean[][][] occur = new boolean[3][3][9];                                         // Number seen in the subgrid
    int number = 0;
    for (int i=0; i<9; ++i) {
        for (int j=0; j<9; ++j) {
            char no = board[i][j];
            if (no != '.'){
                number = Integer.parseInt(String.valueOf(no))-1;                        // As the indices start from 0
                if(row[i][number] == false){
                    row[i][number] = true;                                              // Mark seen in row
                } else {return false;}
                if(col[j][number] == false){
                    col[j][number] = true;                                              // Mark seen in column
                } else {return false;}
                if(occur[i/3][j/3][number] == false){
                    occur[i/3][j/3][number] = true;                                     // Mark seen in sub grid
                } else {return false;}                                                  // False if seen again
            }
        }
    }
    return true;                                                                        // Valid sudoku as all good
}
}

