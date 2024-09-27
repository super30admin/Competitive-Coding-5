/**
 * @author Vishal Puri
 * // Time Complexity : O(n^3)
 * // Space Complexity : O(1)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) return false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (!isSafe(board, i, j, c))
                    return false;
            }
        }
        return true;
    }

    private boolean isSafe(char[][] board, int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == ch && r != i) {
                System.out.println("test1" + i + " " + c + " " + r);
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == ch && c != i) {
                System.out.println("test2" + r + " " + i);
                return false;
            }
        }
        int m = r / 3;
        int n = c / 3;
        for (int i = m * 3; i < m * 3 + 3; i++) {
            for (int j = n * 3; j < n * 3 + 3; j++) {
                if (board[i][j] == ch && i != r && j != c) {
                    System.out.println("test3" + i + " " + j);
                    return false;
                }
            }
        }
        return true;
    }
}