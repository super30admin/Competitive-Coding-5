
// Time Complexity : O(n*n)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Create 3 2D arrays for marking row, marking column and marking box. We iterate through all the elements of 
given sudoku. Whenever we find the number, we mark respective row and that number(position) as 1. If the position 
is already 1 then return false. Same for column. For box, we find box index using (r / 3) * 3 + c / 3.
*/
class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // Use an array to record the status
        int[][] rows = new int[N][N];
        int[][] cols = new int[N][N];
        int[][] boxes = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // Check if the position is filled with number
                if (board[r][c] == '.') {
                    continue;
                }
                int pos = board[r][c] - '1';

                // Check the row
                if (rows[r][pos] == 1) {
                    return false;
                }
                rows[r][pos] = 1;

                // Check the column
                if (cols[c][pos] == 1) {
                    return false;
                }
                cols[c][pos] = 1;

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx][pos] == 1) {
                    return false;
                }
                boxes[idx][pos] = 1;
            }
        }
        return true;
    }
}