// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Check each row, column and 3*3 block for distinct numbers using a HashSet.

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || (board.length != 9 && board[0].length != 9) ) return false;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(Character.isDigit(board[i][j]) && set.contains(Character.getNumericValue(board[i][j])) ){
                    return false;
                } else if(Character.isDigit(board[i][j]) ){
                    set.add(Character.getNumericValue(board[i][j]));
                }
            }
            set.clear();
        }
        
        for(int j = 0; j < 9; j++){
            for(int i = 0; i < 9; i++){
                if(Character.isDigit(board[i][j]) && set.contains(Character.getNumericValue(board[i][j])) ){
                    return false;
                } else if(Character.isDigit(board[i][j]) ){
                    set.add(Character.getNumericValue(board[i][j]));
                }
            }
            set.clear();
        }
        set.clear();
        int[][] start = {{0,0},{0,3},{0,6},{3,0},{3,3},{3,6},{6,0},{6,3},{6,6}};
        
        for(int k = 0; k < 9; k++){
            int p = start[k][0];
            int q = start[k][1];
            
            int iLoop = p + 3;
            int jLoop = q + 3;
            
            for(int i = p; i < iLoop; i++){
                for(int j = q; j < jLoop; j++){
                    if(Character.isDigit(board[i][j]) && set.contains(Character.getNumericValue(board[i][j])) ){
                        return false;
                    } else if(Character.isDigit(board[i][j]) ){
                        set.add(Character.getNumericValue(board[i][j]));
                    }
                }              
            }
            set.clear();
        }
        
        return true;
    }
}
