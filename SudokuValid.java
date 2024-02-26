// Time Complexity : O(2*m*n) ~ O(m*n)
// Space Complexity : ((2 * m * 10) + (m * 10)) ~ O(20m + 10m) ~ O(30m) ~ O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


/**
 * I'm going to iterate over each row and col to see if they contains duplicates return false;
 * Then again iterate over each block of 3*3 and check if they contain duplicates
 */

import java.util.HashSet;

class Solution {
    int m;
    int n;

    public boolean isValidSudoku(char[][] board) {
        m = board.length;
        n = board[0].length;
        // return helperHashSet(board);
        return helper(board);
    }

    private boolean helper(char[][] board) {
        char dot = '.';
        char zero = '0';
        boolean set[];
        boolean[] setRow;
        // for row and col check
        for (int i = 0; i < m; i++) {
            set = new boolean[10];
            setRow = new boolean[10];
            for (int j = 0; j < n; j++) {

                if (board[i][j] != dot) {
                    // for row check
                    int rowVal = board[i][j] - zero;
                    if (setRow[rowVal]) {
                        return false;
                    } else {
                        setRow[rowVal] = true;
                    }
                }

                if (board[j][i] != dot) {
                    // for column check
                    int val = board[j][i] - zero;
                    if (set[val]) {
                        return false;
                    } else {
                        set[val] = true;
                    }
                }
            }
        }

        // for block check
        for (int I = 0; I < m; I += 3) {
            for (int J = 0; J < n; J += 3) {
                set = new boolean[10];

                for (int i = I; i < (I + 3); i++) {
                    for (int j = J; j < (J + 3); j++) {
                        if (board[i][j] != dot) {
                            int val = board[i][j] - zero;
                            if (set[val]) {
                                return false;
                            } else {
                                set[val] = true;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    private boolean helperHashSet(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char bVal = board[i][j];
                if (bVal != '.') {
                    if (!(set.add(bVal + "r" + i))) {
                        return false;
                    }

                    if (!(set.add(bVal + "c" + j))) {
                        return false;
                    }

                    if (!(set.add(bVal + "b" + i / 3 + j / 3))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}