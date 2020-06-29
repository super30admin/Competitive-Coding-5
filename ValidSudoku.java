// Time Complexity : O(m*n). m is the number of rows. n is the number of columns
// Space Complexity : O(m*n).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        if(board == null || board.length == 0)
            return false;

        HashSet<String> set = new HashSet<>();

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {

                if(board[i][j] != '.') {
                    if(!set.add(board[i][j] + " stored in row " + i) || 
                      !set.add(board[i][j] + " stored in column " + j) || 
                      !set.add(board[i][j] + " stored in box " + i/3 + j/3)) {
                        return false;
                    }
                }

            }
        }

        return true;
    }
}
