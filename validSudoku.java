// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach in three
// sentences only
/*
 * check for every row, column and block if the value repeats, if so return false. else set the the index to true;
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        // checking row for duplicate values
        for (int i = 0; i < 9; i++) {
            boolean[] check = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (check[(int) (board[i][j] - '1')])
                        return false;
                    check[(int) (board[i][j] - '1')] = true;
                }

            }
        }

        // checking column for duplicate values
        for (int j = 0; j < 9; j++) {
            boolean[] check = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (check[(int) (board[i][j] - '1')])
                        return false;
                    check[(int) (board[i][j] - '1')] = true;
                }
            }
        }

        for (int box = 0; box < 9; box++) {
            boolean[] check = new boolean[9];

            for (int i = box / 3 * 3; i < box / 3 * 3 + 3; i++) {
                for (int j = box % 3 * 3; j < box % 3 * 3 + 3; j++) {
                    if (board[i][j] != '.') {
                        if (check[(int) (board[i][j] - '1')])
                            return false;
                        check[(int) (board[i][j] - '1')] = true;
                    }
                }
            }
        }
        return true;
    }
}