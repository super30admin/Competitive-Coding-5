/**
 * Time Complexity: O(N^2)
 * Space Complexity: O(N^2)
 */

class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] grids = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int value = board[i][j] - '1';
                int gridIndex = ((i / 3) * 3) + (j / 3);

                if (rows[i][value] || columns[j][value] || grids[gridIndex][value]) {
                    return false;
                }
                rows[i][value] = true;
                columns[j][value] = true;
                grids[gridIndex][value] = true;
            }
        }
        return true;
    }
}