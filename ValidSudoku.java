/**
 * Time Complexity = O(1) as sudoku board has fixed 9 x 9 elements
 * Space Complexity = O(1) as sudoku board has fixed 9 x 9 elements
 * Approach: Check for repeated occurences in 9 rows, 9 cols, 9 3x3 grids
 *           If there is any repeated occurence then return false else return true
 */
​
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // if all the 9 3x3 grids are valid and all the 9 rows are valid and all the 0 cols are valid then return true
        if(areAllGridsValid(board) && areAllRowsValid(board) && areAllColsValid(board)) {
            return true;
        }
        // if one of the constraints is not valid then return false
        return false;
    }
    
    // Helper function to check the validity of all 9 3x3 grids
    private boolean areAllGridsValid(char[][] board) {
        
        for(int i = 0 ; i < 9 ; i += 3) {
            for(int j = 0 ; j < 9 ; j += 3) {
                // if one of the 3x3 is not valid then return false
                if(!isGridValid(board, i, j)) {
                    return false;
                }
            }
        }
        // if all the 9 3x3 grids are valid then return true
        return true;
    }
    
    // Helper function to check the validity of all 9 rows
    private boolean areAllRowsValid(char[][] board) {
        
        for(int i = 0 ; i < 9 ; i++) {
            // if one of the 9 rows is not valid then return false
            if(!isRowValid(board, i)) {
                return false;
            }
        }
        // if all the 9 rows are valid then return true
        return true;
    }
    
    // Helper function to check the validity of all 9 cols
    private boolean areAllColsValid(char[][] board) {
        
        for(int i = 0 ; i < 9 ; i++) {
            // if one of the 9 cols is not valid then return false
            if(!isColValid(board, i)) {
                return false;
            }
        }
        // if all the 9 cols are valid then return true
        return true;
    }
    
    // Helper function to check validity of each row
    private boolean isRowValid(char[][] board, int row) {
        
        // initialize a boolean array to track the occurence of numbers from 1 to 9 in the row
        boolean[] seen = new boolean[9];
        
        // Loop over each character of row
        for(int i = 0 ; i < 9 ; i++) {
            // if current character is a digit and is already seen before then row is not valid so return false
            if(Character.isDigit(board[row][i])) {
                if(seen[board[row][i] - '1']) {
                    return false;
                }
                // if the current character is a digit and is not seen before then mark that number as seen and continue
                seen[(board[row][i] - '0') - 1] = true;
            }
        }
        
        // if the row contains unique numbers then return true
        return true;
    }
    
    // Helper function to check validity of each col
    private boolean isColValid(char[][] board, int col) {
        
        // initialize a boolean array to track the occurence of numbers from 1 to 9 in the col
        boolean[] seen = new boolean[9];
        
        // Loop over each characters of col
        for(int i = 0 ; i < 9 ; i++) {
            // if current character is a digit and is already seen before then col is not valid so return false
            if(Character.isDigit(board[i][col])) {
                if(seen[board[i][col] - '1']) {
                    return false;
                }
                // if the current character is a digit and is not seen before then mark that number as seen and continue
                seen[board[i][col] - '1'] = true;
            }
        }
        
        // if the col contains unique numbers then return true
        return true;
    }
    
    // Helper function to check validity of each 3x3 grid
    private boolean isGridValid(char[][] board, int row, int col) {
        // initialize a boolean array to track the occurence of numbers from 1 to 9 in the 3x3 grid
        boolean[] seen = new boolean[9];
        
        // Loop over each character of 3x3 grid
        for(int i = 0 ; i < 3 ; i++) {
            for(int j = 0 ; j < 3 ; j++) {
                // if current character is a digit and is already seen before then 3x3 grid is not valid so return false
                if(Character.isDigit(board[row + i][col + j]) ) {
                    if(seen[board[row + i][col + j] - '1']) { 
                        return false;
                    }
                    // if the current character is a digit and is not seen before then mark that number as seen and continue
                    seen[board[row + i][col + j] - '1'] = true;
                }
            }
        }
        
        return true;
    }
}
