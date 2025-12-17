// Time Complexity : O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// Use HashSets to keep track of digits seen in each row, column, and 3x3 sub-box
// Traverse the board and for each non-empty cell, check for duplicates in row, column, and box
// If any duplicate is found return false; if traversal completes, return true

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        // Initialize sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];

                if (val == '.') {
                    continue;
                }

                // Row check
                if (rows[i].contains(val)) {
                    return false;
                }
                rows[i].add(val);

                // Column check
                if (cols[j].contains(val)) {
                    return false;
                }
                cols[j].add(val);

                // Box check
                int boxIdx = (i / 3) * 3 + (j / 3);
                if (boxes[boxIdx].contains(val)) {
                    return false;
                }
                boxes[boxIdx].add(val);
            }
        }

        return true;
    }
}
