// Time Complexity: O(9^2)
// Space Complexity: O(9^2)
// Ran on Leetcode successfully: yes
class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        // Traverse every cell in the 9x9 Sudoku board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                // if empty continue
                if (board[r][c] == '.') continue;

                // Convert character '1'-'9' to index 0-8
                int num = board[r][c] - '1';

                // Determine which 3x3 box the cell belongs to
                int box = (r / 3) * 3 + (c / 3);

                // If the number already appeared then the Sudoku board is invalid
                if (rows[r][num] || cols[c][num] || boxes[box][num]) {
                    return false;
                }
                // Mark as seen
                rows[r][num] = true;
                cols[c][num] = true;
                boxes[box][num] = true;
            }
        }

        // If no rule was violated
        return true;
    }
}