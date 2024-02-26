// Time Complexity : O(1) - always iterates over a constant-sized board (9x9 cells). 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Coming up with logic

import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cellVal = board[i][j];

                // If cell value is not empty
                if (cellVal != '.') {
                    if (!seen.add(cellVal + " Found in row " + i)
                            || !seen.add(cellVal + " Found in column " + j)
                            || !seen.add(cellVal + " Found in sub box " + i / 3 + " - " + j / 3)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}