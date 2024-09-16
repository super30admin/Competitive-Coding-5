// Time Complexity : O(M*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //corner case
        if(board == null || board.length != 9 || board[0].length != 9) return false;

        //main logic
        //rows
        for(int i=0; i<9; i++) {
            boolean[] b = new boolean[9];
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') {
                    if(b[Character.getNumericValue(board[i][j])-1] ) return false;
                    b[Character.getNumericValue(board[i][j])-1] = true;
                }
            }
        }

        //columns
        for(int j=0; j<9; j++) {
            boolean[] b = new boolean[9];
            for(int i=0; i<9; i++) {
                if(board[i][j] != '.') {
                    if(b[Character.getNumericValue(board[i][j])-1] ) return false;
                    b[Character.getNumericValue(board[i][j])-1] = true;
                }
            }
        }

        //blocks

        for(int block = 0; block <9; block ++) {
            boolean[] b = new boolean[9];
            for(int i=block/3*3; i<block/3*3+3; i++) {
                for(int j=block%3*3; j<block%3*3+3; j++) {
                    if(board[i][j] != '.') {
                        if(b[Character.getNumericValue(board[i][j])-1] ) return false;
                        b[Character.getNumericValue(board[i][j])-1] = true;
                    }
                }
            }
        }
        return true;
    }
}
