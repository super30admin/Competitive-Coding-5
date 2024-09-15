// Time Complexity : O(m*n) where m = n = 9 in this 9*9 grid
// Space Complexity : O(3*m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check for edge cases
        if(board == null || board.length != 9 || board[0].length != 9)
            return false;
        
        // 3 boolean arrays to keep a track of rows, cols and grids
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] grid = new boolean[9][9];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // skip the '.' element
                if (board[i][j] == '.') continue;
                
                // convert the char to integer 
                // I subtract '1' and not '0' since the boolean matrices are 0 indexed 
                // if I subtract '1', i will try to acces the array out of their bounds
                int x = board[i][j] - '1';
                
                // calculate the row of the 3*3 grid
                // Basically I am mapping 9 * 9 matrix to 3 * 3 matrix
                // So (i/3)*3 will determine row of the each 3 * 3 matrix
                // Example suppose i is 6,7 or 8 that means we have seen i/3 i.e. 2 rows of 3 * 3 matrix
                // therefore we multiply 2 * 3 (6 boxes are already covered i.e. 0 1 2 3 4 and 5)
                // j is simply adding column
                //        |        |   
                //    0   |   1    |   2  
                //        |        |   
                // --------+---------+---------
                //        |         |   
                //    3   |     4   |    5  
                //        |         |     
                // --------+----------+--------
                //        |         | 
                //    6   |     7   |    8  
                //        |         |     
                int gridRow = 3 * (i / 3) + (j / 3);
                
                // if any of the boolean arrays i.e. row, col, or 3*3 grid already has the given element return false
                // since the sudoku is not valid
                if (row[i][x] || col[j][x] || grid[gridRow][x]) {
                    return false;
                }
                
                // else add the element to all 3 boolean arrays                
                row[i][x] = true;
                col[j][x] = true;
                grid[gridRow][x] = true;
            }
        }
        
        // if we reach till this point the entire sudoku is valid and we return true
        return true;
    }
}