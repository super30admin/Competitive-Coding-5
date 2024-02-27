// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Using 3 sets for row, column and box. Using unique strings in the hashset
// to track if any number is repeated in a particular row, column or box.

import java.util.HashSet;
import java.util.Set;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // if any element is repeated in the sets; return false
        Set<String> rowSet = new HashSet();
        Set<String> colSet = new HashSet();
        Set<String> boxSet = new HashSet();

        StringBuilder currentString = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char current = board[i][j];

                if (current == '.')
                    continue;

                String rowString = i + "" + current;
                // 09 means 9 exists in 0th row
                if (rowSet.contains(rowString)) {
                    return false;
                }
                rowSet.add(rowString);

                String columnString = j + "" + current;
                // 09 means 9 exists in 0th column
                if (colSet.contains(columnString)) {
                    return false;
                }
                colSet.add(columnString);

                // 009 means 9 exists in box 0
                // 021 means 1 exists in box 2

                String boxString = i / 3 + "" + j / 3 + "" + current;
                if (boxSet.contains(boxString)) {
                    return false;
                }
                boxSet.add(boxString);
            }
        }

        return true;
    }
}