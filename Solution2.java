//Time complexity: O(M*N), where M*N is the size of the board. 
//Space complexity: O(1) for any board.

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowSet = new boolean[9][9];
        boolean[][] columnSet = new boolean[9][9];
        boolean[][] boxSet = new boolean[9][9];
         
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if (board[i][j] != '.') {
                    //number
                    int num = board[i][j] - '1';
                    //box number
                    int box = j / 3 + (i / 3) * 3;
                    //check if the number is already seen
                    if (rowSet[i][num] || columnSet[j][num] || boxSet[box][num])
                        return false;
                    //set the row, column and box for the number to true
                    rowSet[i][num] = true;
                    columnSet[j][num] = true;
                    boxSet[box][num] = true;
                }
            }
        }
        return true;
    }
}