// Time Complexity :O(n*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class SudokuValidator {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        int[] check;

        // check rows
        for (int r = 0; r < N; r++) {
            check = new int[N];
            for (int c = 0; c < N; c++) {
                if (board[r][c] == '.')
                    continue;

                if (check[board[r][c] - '1'] == 1)
                    return false;

                check[board[r][c] - '1'] = 1;
            }
        }

        // check columns
        for (int c = 0; c < N; c++) {
            check = new int[N];
            for (int r = 0; r < N; r++) {
                if (board[r][c] == '.')
                    continue;

                if (check[board[r][c] - '1'] == 1)
                    return false;

                check[board[r][c] - '1'] = 1;
            }
        }

        // check grid
        for (int box = 0; box < N; box++) {
            check = new int[N];
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    int r = row + 3 * (box / 3);
                    int c = col + 3 * (box % 3);

                    if (board[r][c] == '.')
                        continue;

                    if (check[board[r][c] - '1'] == 1)
                        return false;

                    check[board[r][c] - '1'] = 1;
                }
            }
        }

        return true;
    }
}
