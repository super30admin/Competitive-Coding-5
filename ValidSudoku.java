//Time Complexity: O(1)
// Space Complexity: O(1)

public class ValidSudoku {
    public boolean isValidSudoku(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // check row
                for (int col = 0; col < n; col++) {
                    if (col == j) {
                        continue;
                    }
                    if (mat[i][j] == mat[i][col]) {
                        return false;
                    }
                }

                // check column
                for (int row = 0; row < m; row++) {
                    if (row == i) {
                        continue;
                    }
                    if (mat[i][j] == mat[row][j]) {
                        return false;
                    }
                }


                // check block
                int sr = (i / 3) * 3, sc = (j / 3) * 3;
                for (int row = sr; row <= sr + 2; row++) {
                    for (int col = sc; col <= sc + 2; col++) {
                        if (i == row && j == col) {
                            continue;
                        }
                        if (mat[i][j] == mat[row][col]) {
                            return false;
                        }
                    }
                }


            }
        }
        return true;
    }
}
