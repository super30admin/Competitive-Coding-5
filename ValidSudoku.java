// Time Complexity : O(m * n) here - O(1)
// Space Complexity : O(m * n) here - O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.HashSet;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i= 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cur = board[i][j];

                if (cur != '.') {
                    if (!seen.add(cur + "row" + i) || !seen.add(cur + "col" + j) || !seen.add(cur + "box_row"+ i/3+"box_col"+ j/3)) return false;
                }
            }
        }
        return true;
    }
}