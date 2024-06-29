// Time Complexity : O(n^2)
// Space Complexity :O(1) contant array of size 9
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            boolean[] rowcheck = new boolean[9]; // array of false
            boolean[] colcheck = new boolean[9]; // array of false, will be true if something of that index exists
            for(int j = 0; j < n; j++) {    
                if(board[i][j] != '.') {
                  if(rowcheck[(int)(board[i][j] - '1')]) {
                    return false; // num exits twice
                  } else {
                    rowcheck[(int)(board[i][j] - '1')] = true; //  num exists
                  }    
                }           
                if(board[j][i] != '.') {
                  if(colcheck[(int)(board[j][i] - '1')]) {
                    return false;
                  } else {
                    colcheck[(int)(board[j][i] - '1')] = true;
                  }    
                }          
            }
        }


        for(int k = 0; k < 9; k++) { // checking grid wise, box by box
            boolean[] boardcheck = new boolean[9];
            for(int i = (k / 3) * 3 ; i < (k / 3 * 3) + 3; i++) { // condition for grid row wise
                for(int j = (k % 3) * 3; j < (k % 3 * 3) + 3; j++) { // condition for grid col wise
                    if(board[i][j] != '.') {
                        if(boardcheck[(int)(board[i][j] - '1')]) {
                            return false;
                        } else {
                            boardcheck[(int)(board[i][j] - '1')] = true;
                        }    
                    }
                }
            }
        }
        return true;
    }
}