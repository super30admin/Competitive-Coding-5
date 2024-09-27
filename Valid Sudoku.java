// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length != 9)
            return false;
        HashSet<Character> rows = new HashSet<>();
        HashSet<Character> cols = new HashSet<>();
        HashSet<Character> box = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char val1 = board[i][j];
                if (val1 != '.') {
                    if (rows.contains(val1)) {
                        return false;
                    }
                    rows.add(val1);
                }
            }
            rows.clear();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char val2 = board[j][i];
                if (val2 != '.') {
                    if (cols.contains(val2)) {
                        return false;
                    }
                    cols.add(val2);
                }

            }
            cols.clear();
        }
        for (int block = 0; block < 9; block++) {

            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    char val3 = board[i][j];
                    if (val3 != '.') {
                        if (box.contains(val3)) {
                            return false;
                        }
                        box.add(val3);
                    }

                }

            }
            box.clear();
        }
        return true;
    }
}