// Time Complexity: O(1)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes  
// Any problem you faced while coding this: No
//approach:
//1. create 3 boolean arrays to keep track of the numbers in the row, column and grid
//2. iterate through the board and check if the number is already in the row, column or grid
//3. if it is, return false
//4. if it is not, add it to the row, column and grid
//5. return true
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] grid= new boolean[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                char ch = board[i][j];
                int index = ch-'1';
                int gridIndex = (i/3)*3+j/3;
                if(row[i][index] || col[j][index] || grid[gridIndex][index]){
                    return false;
                }
                row[i][index] = true;
                col[j][index] = true;
                grid[gridIndex][index] = true;

            }
        }
        return true;
    }
}

