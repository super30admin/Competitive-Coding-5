// Time Complexity: O(1) - The size of the board is fixed (9x9), so the operations are constant.
// Space Complexity: O(1) - The space required for the hash set is limited to a fixed size as it's a 9 x 9 board.

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> exist = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] != '.') {
                    String currentRow = board[i][j] + " in row " + i;
                    String currentColumn = board[i][j] + " in column " + j;
                    String Subbox = board[i][j] + " in sub-box " + i/3 + "-" + j/3;

                    if (!exist.add(currentRow) || !exist.add(currentColumn) || !exist.add(Subbox)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
