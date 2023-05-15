// Time Complexity : O(rc) where r and c are rows and columns respectively
// Space Complexity : O(rc)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/*
 * Approach:
 * We use a HashSet in order to determine uniqueness in each row, column
 * and block in the sudoku matrix.
 */

import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0) {
            return false;
        }

        int n = board.length;

        HashSet<Character>[] rowSet = new HashSet[n];
        HashSet<Character>[] colSet = new HashSet[n];
        HashSet<Character>[][] blockSet = new HashSet[n][n];

        for(int i=0; i<n; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
        }

        for(int i=0; i<n/3; i++) {
            for(int j=0; j<n/3; j++) {
                blockSet[i][j] = new HashSet<>();
            }
        }

        for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                if(board[r][c] == '.') continue;
                
                if(rowSet[r].contains(board[r][c])) {
                    return false;
                }
                rowSet[r].add(board[r][c]);

                if(colSet[c].contains(board[r][c])) {
                    return false;
                }
                colSet[c].add(board[r][c]);

                if(blockSet[r/3][c/3].contains(board[r][c])) {
                    return false;
                }
                blockSet[r/3][c/3].add(board[r][c]);
            }
        }

        return true;
    }
}