// Time Complexity : O(3 M*N)
// Space Complexity : O(3 M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length !=9) return false;
        // check row level values
        for(int i=0;i<board.length;i++) {
            boolean[] check = new boolean[board.length];
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] != '.') {
                    if(check[Character.getNumericValue(board[i][j])-1] ) return false;
                    check[Character.getNumericValue(board[i][j])-1] = true;

                }
            }
        }
        // check column level values
        for(int i=0;i<board.length;i++) {
            boolean[] check = new boolean[board.length];
            for(int j=0;j<board[0].length;j++) {
                if(board[j][i] != '.') {
                    if(check[Character.getNumericValue(board[j][i])-1] ) return false;
                    check[Character.getNumericValue(board[j][i])-1] = true;
                }
            }
        }
        // explore block level,
        // traverse through the mid of every block,
        // then explore all the directions from there
        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int i=1;i<board.length;i = i+3) {
            for(int j=1;j<board[0].length;j = j+3) {
                boolean[] check = new boolean[board.length];
                if(board[i][j] != '.')
                    check[Character.getNumericValue(board[i][j])-1] = true;
                for(int[] dir: dirs) {
                    int row = dir[0]+i;
                    int col = dir[1]+j;
                    if(board[row][col] != '.') {
                        if(check[Character.getNumericValue(board[row][col])-1]) return false;
                        check[Character.getNumericValue(board[row][col])-1] = true;
                    }}
            }
        }
        return true;
    }
}