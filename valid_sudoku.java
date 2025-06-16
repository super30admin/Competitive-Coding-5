// Time complexity -> O(1)
// Space Complexity -> O(1)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;

        // Check rows
        for (int r = 0; r < 9; r++) {
            boolean[] map = new boolean[9];
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int idx = board[r][c] - '1';
                    if (map[idx]) return false;
                    map[idx] = true;
                }
            }
        }

        // Check columns
        for (int c = 0; c < 9; c++) {
            boolean[] map = new boolean[9];
            for (int r = 0; r < 9; r++) {
                if (board[r][c] != '.') {
                    int idx = board[r][c] - '1';
                    if (map[idx]) return false;
                    map[idx] = true;
                }
            }
        }

        // Check 3x3 sub-boxes
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                boolean[] map = new boolean[9];
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        char val = board[boxRow * 3 + r][boxCol * 3 + c];
                        if (val != '.') {
                            int idx = val - '1';
                            if (map[idx]) return false;
                            map[idx] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
