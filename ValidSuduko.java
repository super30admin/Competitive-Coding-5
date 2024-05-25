// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        if(board == null || m != 9 || n != 9) {
            return false;
        }

        // row
        for(int i=0;i< 9;i++) {
            boolean[] valid = new boolean[9];
            for(int j=0;j< 9;j++) {
                char c = board[i][j];

                if( c != '.') {
                    if(valid[(int)c-'1']) return false;
                    valid[(int)c - '1'] = true;
                }
            }
        }

        // column
        for(int j=0;j< m;j++) {
            boolean[] valid = new boolean[9];
            for(int i=0;i< n;i++) {
                char c = board[i][j];

                if( c != '.') {
                    if(valid[(int)c-'1']) return false;
                    valid[(int)c - '1'] = true;
                }
            }
        }

        // block
        for(int block=0;block<9;block++) {
            boolean[] valid = new boolean[9];
            for(int i=block/3*3;i< block/3*3+3;i++) {

                for(int j=block%3*3;j< block%3*3+3;j++) {
                    char c = board[i][j];

                    if( c != '.') {
                        if(valid[(int)c-'1']) return false;
                        valid[(int)c - '1'] = true;
                    }
                }
            }
        }

        return true;
    }
}