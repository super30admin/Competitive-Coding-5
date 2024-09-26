//TIme : O (mxnx9)
// Space : O(mxnx9)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // row
        for (int i = 0; i < 9; i++) {
            boolean[] b = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    System.out.println((board[i][j] - '0'));
                    if (b[(int) (board[i][j] - '1')])
                        return false;
                    b[(int) (board[i][j] - '1')] = true;
                }
            }
        }

        // column
        for (int i = 0; i < 9; i++) {
            boolean[] b = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (b[(int) (board[j][i] - '1')])
                        return false;
                    b[(int) (board[j][i] - '1')] = true;
                }
            }
        }

        // block
        for (int blo = 0; blo < 9; blo++) {
            boolean[] b = new boolean[9];
            for (int i = blo / 3 * 3; i < blo / 3 * 3 + 3; i++) {
                for (int j = blo % 3 * 3; j < blo % 3 * 3 + 3; j++) {
                    if (board[i][j] != '.') {
                        if (b[(int) (board[i][j] - '1')])
                            return false;
                        b[(int) (board[i][j] - '1')] = true;
                    }
                }
            }
        }

        return true;

    }
}