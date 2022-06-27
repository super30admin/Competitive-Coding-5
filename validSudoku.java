// https://leetcode.com/problems/valid-sudoku/

// Time Complexity: O(n^2) Traversing row and column 
// Space Complexity: O(n^2) Traversing row and column 
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took ref from video

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Null case
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;

        // Row validation
        for (int i = 0; i < 9; i++) {
            boolean[] b = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (b[(int) (board[i][j] - '1')])
                        return false;
                    b[(int) (board[i][j] - '1')] = true;
                }
            }
        }

        // Column validation
        for (int i = 0; i < 9; i++) {
            boolean[] col = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (col[(int) (board[j][i] - '1')])
                        return false;
                    col[(int) (board[j][i] - '1')] = true;
                }
            }
        }

        // Block validation
        for (int block = 0; block < 9; block++) {
            boolean[] blockBool = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (board[j][i] != '.') {
                        if (blockBool[(int) (board[j][i] - '1')])
                            return false;
                        blockBool[(int) (board[j][i] - '1')] = true;
                    }
                }
            }
        }

        return true;
    }
}