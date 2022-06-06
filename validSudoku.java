// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
//at each row level, column level and grid level, we are making a boolean array of size 9 to check if 
//number is repeating or not
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board[0].length == 0)
            return false;
        // check rows
        for (int i = 0; i < 9; i++) {
            boolean[] checkArr = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = Character.getNumericValue(board[i][j]);
                    if (checkArr[num]) {
                        return false;
                    }
                    checkArr[num] = true;
                }

            }
        }

        // check column
        for (int i = 0; i < 9; i++) {
            boolean[] checkArr = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int num = Character.getNumericValue(board[j][i]);
                    if (checkArr[num]) {
                        return false;
                    }
                    checkArr[num] = true;
                }

            }
        }
        // check Block
        for (int i = 0; i < 9; i++) {
            int boardRow = i / 3;
            int boardCol = i % 3;
            boolean[] checkArr = new boolean[10];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int row = 3 * boardRow + j;
                    int col = 3 * boardCol + k;
                    if (board[row][col] != '.') {
                        int num = Character.getNumericValue(board[row][col]);
                        if (checkArr[num]) {
                            return false;
                        }
                        checkArr[num] = true;
                    }

                }
            }
        }
        return true;
    }
}