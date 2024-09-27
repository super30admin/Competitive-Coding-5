/**
 * Problem: https://leetcode.com/problems/valid-sudoku/ 
 * TC: O(1)
 * SC: O(1)
*/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board[0].length == 0) {
            return true;
        }
        
        // rows
        for (int i = 0; i < 9; ++i) {
            boolean seen[] = new boolean[9];
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.')
                    continue;
                int index = Character.getNumericValue(board[i][j]) - 1;
                if (seen[index]) {
                    return false;
                }
                seen[index] = true;
            }
        }
        
        // columns
        for (int j = 0; j < 9; ++j) {
            boolean seen[] = new boolean[9];
            for (int i = 0; i < 9; ++i) {
                if (board[i][j] == '.')
                    continue;
                int index = Character.getNumericValue(board[i][j]) - 1;
                if (seen[index]) {
                    return false;
                }
                seen[index] = true;
            }
        }
        
        //  blocks
        for (int blocks = 0; blocks < 9; ++blocks) {
            boolean seen[] = new boolean[9];
            for (int i = blocks / 3 * 3; i < blocks / 3 * 3 + 3; ++i) {
                for (int j = blocks % 3 * 3; j < blocks % 3 * 3 + 3; ++j) {
                    if (board[i][j] == '.')
                        continue;
                    int index = Character.getNumericValue(board[i][j]) - 1;
                    if (seen[index]) {
                        return false;
                    }
                    seen[index] = true;
                }
            }
        }
        return true;
    }
}