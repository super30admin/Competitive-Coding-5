// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isValidSudoku(char[][] board) {
        return rowCheck(board) 
            && columnCheck(board)
            && boxCheck(board);
    }
    
    public boolean rowCheck(char[][] board) {

        for(int i = 0; i < 9; i++) {
            Set<Character> seenValues = new HashSet<>();

            for(int j = 0; j < 9; j++) {
                if(!isValid(seenValues, board[i][j]))
                    return false;
            }
        }
        
        return true;
    }
    
    public boolean columnCheck(char[][] board) {
        for(int i = 0; i < 9; i++) {

            Set<Character> seenValues = new HashSet<>();
            for(int j = 0; j < 9; j++) {

                if(!isValid(seenValues, board[j][i]))
                    return false;
            }
        }
        
        return true;
    }
    
    public boolean boxCheck(char[][] board) {
        for(int i = 0; i < 9; i++) {
            Set<Character> seenValues = new HashSet<>();
            
            int rowStart = i / 3 * 3;
            int colStart = i % 3 * 3;
            for(int row = rowStart; row < rowStart + 3; row++) {
                for(int col = colStart; col < colStart + 3; col++) {
                    if(!isValid(seenValues, board[row][col]))
                        return false;
                }
            }
        }
        
        return true;
    }
    
        
    public boolean isValid(Set<Character> seenValues, char value) {
        if(value != '.' && !seenValues.add(value))
            return false;
        return true;
    }
}