// This is a identification problem
// So, we have to figure out what's common between a row, a column and a grid.
// let's take row+i+ board[i][j] for row identification
// let's take col+j+board[i][j] for column identification
// let's take grid+ i/3 + j/3 + board[i][j]. It does not matter whether  i/3 + j/3 will be a sum of two numbers.
// Time complexity = O(m*n)
// Space complexity = O(3*m*n). yes O(3*m*n), since grid, row and col is included in just 1 set.
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Set<String> set = new HashSet<>();// can contain everything ranging from 
        for(int i=0;i< m ;i++ ) {
            for(int j=0;j< n ;j++) {
                if(board[i][j] != '.') {
                    // for row check.
                    StringBuilder sb = new StringBuilder();
                    sb.append("row").append(i).append(board[i][j]);
                    String rowString = sb.toString();
                    if(set.contains(rowString)) {
                        return false;
                    }
                    set.add(rowString);
                    
                    // for column check
                    sb = new StringBuilder();
                    sb.append("col").append(j).append(board[i][j]);
                    String colString = sb.toString();
                    if(set.contains(colString)) {
                        return false;
                    }
                    set.add(colString);
                    // for grid check
                    sb = new StringBuilder();
                    sb.append("grid").append(i/3).append(j/3).append(board[i][j]);
                    String gridString = sb.toString();
                    if(set.contains(gridString)) {
                        return false;
                    }
                    set.add(gridString);
                    
                }

            }
        }
        return true;
    }
}