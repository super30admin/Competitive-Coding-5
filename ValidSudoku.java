// Time Complexity : O(1) because number of rows and columns is 9
// Space Complexity : O(1) because number of rows and columns is 9
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // Check each row and column for duplicates.
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i)) {
                return false;
            }
        }

        // Check each 3x3 sub-box for duplicates.
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSubBox(board, i, j)) {
                    return false;
                }
            }
        }

        return true; // If all checks pass, the Sudoku board is valid.
    }

    private boolean isValidRow(char[][] board, int row) {
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char num = board[row][i];
            if (num != '.' && !seen.add(num)) {
                return false; // Duplicate found in the row.
            }
        }
        return true;
    }

    private boolean isValidColumn(char[][] board, int col) {
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char num = board[i][col];
            if (num != '.' && !seen.add(num)) {
                return false; // Duplicate found in the column.
            }
        }
        return true;
    }

    private boolean isValidSubBox(char[][] board, int row, int col) {
        Set<Character> seen = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                char num = board[i][j];
                if (num != '.' && !seen.add(num)) {
                    return false; // Duplicate found in the sub-box.
                }
            }
        }
        return true;
    }
}