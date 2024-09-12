package Nov15;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        
/*
       
     Time Complexity: O(1)
     Although we are iterating over all the 81 elements in two different nested for loops, yet since it is a 9*9 sudoku board given in the problem statement, it will be constant time access.
    
     Space Complexity: O(1)
     Arrays for rowCheck, colCheck and blockCheck are all single dim arrays of fixed size 9 to track all the digits from 0-9 applicable for a Sudoku puzzle, hence space is also constant.
   
     Did this code successfully run on Leetcode : Yes
    
     Any problem you faced while coding this : No
       
*/   
        
        // edge
        if (board == null || board.length == 0) {
            return true;
        }  

        // checking for values across a row if there are no repetitions of filled digits
        for (int i = 0; i < 9; i++) {
            boolean[] rowCheck = new boolean[9];
            boolean[] colCheck = new boolean[9];
            for (int j = 0; j < 9; j++) {  
                // Mark all elements in rowCheck array as true for which index value+1 = an element present in the current row
                // if any of the elements are repeated in current row, rowCheck value will already be marked True for that element in some prev iteration, hence we can return false from this scenario itself, because it will not be a valid sudoku
                if (board[i][j] != '.' && rowCheck[(int) board[i][j]-'0' -1] == true ) {
                    return false;
                } else if (board[i][j] != '.' && rowCheck[(int) board[i][j]-'0' -1] != true ) {
                    rowCheck[(int) board[i][j]-'0' -1] = true;
                }  
                // Mark all elements in colCheck array as true for which index value+1 = an element present in the current column
                // if any of the elements are repeated in current col, colCheck value will already be marked True for that element in some prev iteration, hence we can return false from this scenario itself, because it will not be a valid sudoku
                if (board[j][i] != '.' && colCheck[(int) board[j][i]-'0' -1] == true ) {
                    return false;
                } else if (board[j][i] != '.' && colCheck[(int) board[j][i]-'0' -1] != true ) {
                    colCheck[(int) board[j][i]-'0' -1] = true;
                } 
            }
        }
    
        // checking for values in a block 
        for (int block = 0; block < 9; block++) {
            boolean[] blockCheck = new boolean[9];
            // process each block and mark all elements in blockCheck array as true for which index value+1 = an element present in the current block 
             // if any of the elements are repeated in current block, blockCheck value will already be marked True for that element in some prev iteration, hence we can return false from this scenario itself, because it will not be a valid sudoku
            int iStart = block/3 * 3;
            int iEnd = iStart + 3;
            for (int i = iStart ; i < iEnd; i++ ) {
                int jStart = block%3 * 3;
                int jEnd = jStart + 3;
                for (int j = jStart; j < jEnd; j++) {
                    if (board[i][j] != '.' && blockCheck[(int) board[i][j]-'0' -1] == true ) {
                        return false;
                    } else if (board[i][j] != '.' && blockCheck[(int) board[i][j]-'0' -1] != true ) {
                        blockCheck[(int) board[i][j]-'0' -1] = true;
                    } 
                }
            }   
        }
       
        // if none of the condition in above loops cause return of false, then it implies that it is a valid sudoku, so we should return true. 
        return true;
    }
}