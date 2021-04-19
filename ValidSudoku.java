// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here  with comments explaining your approach

class Solution {
  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      HashSet<Character> rows = new HashSet<Character>();
      HashSet<Character> columns = new HashSet<Character>();
      HashSet<Character> cube = new HashSet<Character>();
      for (int j = 0; j < 9; j++) {
        // Check duplicates for each row
        if (board[i][j] != '.' && !rows.add(board[i][j]))
          return false;
        // Check duplicates for each column
        if (board[j][i] != '.' && !columns.add(board[j][i]))
          return false;
        // Separe the rows and columns to individual cubes
        int row = 3 * (i / 3);
        int col = 3 * (i % 3);
        if (board[row + j / 3][col + j % 3] != '.' && !cube.add(board[row + j / 3][col + j % 3]))
          return false;
      }
    }
    return true;
  }
}