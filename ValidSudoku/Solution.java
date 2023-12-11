// Time Complexity : O(3 n^2) -> O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Solution 1
 */
class Solution {
    int m, n;
    public boolean isValidSudoku(char[][] board) {

        this.m = board.length;
        this.n = board[0].length;

        boolean rowFlag = checkRow(board);

        if(!rowFlag) return false;

        boolean colFlag = checkCol(board);

        if(!colFlag) return false;

        boolean flag = checkCells(board);

        if(!flag) return false;

        return true;
    }

    private boolean checkRow(char[][] board) {

        for(int i=0; i<m; i++) {

            HashSet<Character> set = new HashSet<>();

            for(int j=0; j<n; j++) {
                char c = board[i][j];
                if(c != '.') {
                    if(set.contains(c))
                        return false;
                    else
                        set.add(c);
                }
            }
        }

        return true;
    }

    private boolean checkCol(char[][] board) {

        for(int i=0; i<m; i++) {

            HashSet<Character> set = new HashSet<>();

            for(int j=0; j<n; j++) {
                char c = board[j][i];
                if(c != '.') {
                    if(set.contains(c))
                        return false;
                    else
                        set.add(c);
                }
            }
        }

        return true;
    }

    private boolean checkCells(char[][] board) {

        int rowLen = 0;
        int colLen = 0;

        for(int a=0; a<9; a+=3) {
            for(int b=0; b<9; b+=3) {
                HashSet<Character> set = new HashSet<>();
                for(int i=a; i<a+3; i++) {
                    for(int j=b; j<b+3; j++) {
                        char c = board[i][j];
                        if(c != '.') {
                            if(set.contains(c))
                                return false;
                            else
                                set.add(c);
                        }
                    }
                }
            }

        }

        return true;
    }
}


/**
 * Shortened version of above solution
 */
// Time Complexity : O(2 n^2) -> O(n^2)
/*
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(checkRowCol(board) && checkCells(board)) return true;
        return false;
    }

    private boolean checkRowCol(char[][] board) {
        for(int i=0; i<9; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            for(int j=0; j<9; j++) {
                if(!check(board[i][j], rowSet)) return false;
                if(!check(board[j][i], colSet)) return false;
            }
        }
        return true;
    }

    private boolean checkCells(char[][] board) {
        for(int a=0; a<9; a+=3)
            for(int b=0; b<9; b+=3) {
                HashSet<Character> set = new HashSet<>();
                for(int i=a; i<a+3; i++)
                    for(int j=b; j<b+3; j++)
                        if(!check(board[i][j], set)) return false;
            }
        return true;
    }

    private boolean check(char c, HashSet<Character> set) {
        if(c != '.')
            if(set.contains(c)) return false;
            else set.add(c);
        return true;
    }
}*/

/**
 * Leetcode Solution 1
 * Hash Set
 */

// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
/*
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // Use hash set to record the status
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = board[r][c];

                // Check if the position is filled with number
                if (val == '.') {
                    continue;
                }

                // Check the row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // Check the column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}
*/


/**
 * Leetcode Solution 2
 * Array of Fixed Length
 */
// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
/*class Solution {
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
}*/


/**
 * Leetcode Solution 3
 * Bitmasking
 */
// Time Complexity : O(n^2)
// Space Complexity : O(n)
/*class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // Use a binary number to record previous occurrence
        int[] rows = new int[N];
        int[] cols = new int[N];
        int[] boxes = new int[N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // Check if the position is filled with number
                if (board[r][c] == '.') {
                    continue;
                }
                int val = board[r][c] - '0';
                int pos = 1 << (val - 1);

                // Check the row
                if ((rows[r] & pos) > 0) {
                    return false;
                }
                rows[r] |= pos;

                // Check the column
                if ((cols[c] & pos) > 0) {
                    return false;
                }
                cols[c] |= pos;

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if ((boxes[idx] & pos) > 0) {
                    return false;
                }
                boxes[idx] |= pos;
            }
        }
        return true;
    }
}*/
