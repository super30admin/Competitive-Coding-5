//time :O(1)
//space :O(1)
class Solution {
    public boolean isValidSudoku(char[][] board) {

        int[][] row = new int[10][10];
        int[][] col = new int[10][10];
        int[][] box = new int[10][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                char c = board[i][j];

                if (c != '.') {

                    row[i][c - '0']++;
                    col[j][c - '0']++;

                    int bid = (i / 3) * 3 + j / 3;
                    box[bid][c - '0']++;

                    if (row[i][c - '0'] > 1 || col[j][c - '0'] > 1 || box[bid][c - '0'] > 1) {

                        return false;
                    }

                }

            }
        }

        return true;

    }
}