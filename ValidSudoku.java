// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
  public boolean isValidSudoku(char[][] board) {
    if(board == null || board.length != 9 || board[0].length != 9) return false;

    boolean[][] rows = new boolean[9][9];
    boolean[][] columns = new boolean[9][9];
    boolean[][] boxes = new boolean[9][9];

    for(int i = 0; i<9; i++) {
      for(int j = 0; j<9; j++) {
        if (board[i][j] == '.') continue; // Skip
        int num = board[i][j] - '1'; // Convert to 0-8
        int boxIndex = (i/3)*3 + j/3;

        if(rows[i][num] || columns[j][num] || boxes[boxIndex][num]) return false; // If number is already pressent, return false.

        rows[i][num] = true;
        columns[j][num] = true;
        boxes[boxIndex][num] = true;
      }
    }
    return true;
  }
}