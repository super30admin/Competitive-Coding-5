// Time Complexity : O(N*N)
// Space Complexity : O(N*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Add each number to the Set, along with the grid, column and row.
// If the element occurs again in the same grid, column or row, we throw false

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet set = new HashSet<>();
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (board[i][j] != '.'){
                    if (set.contains(i/3+":"+j/3+":G:"+board[i][j]) || 
                        set.contains(i+":R:"+board[i][j]) || 
                        set.contains(j+":C:"+board[i][j]))
                        return false;
                    set.add(i/3+":"+j/3+":G:"+board[i][j]);
                    set.add(i+":R:"+board[i][j]);
                    set.add(j+":C:"+board[i][j]);
                }
            }
        }

		return true;
        
    }
}