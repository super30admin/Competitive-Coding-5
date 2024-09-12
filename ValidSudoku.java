// TC: O(1)
// SC: O(1)
// Did it run sucessfully on Leetcode? : Yes
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
              return false;
        HashSet<String> seen = new HashSet();
        for ( int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                char c = board[i][j];
                if (c != '.')
                {
                  if (!seen.add(c + " found at row " + i) || 
                      !seen.add(c + " found at column " + j) || 
                      !seen.add(c + " found at box " + i/3 + "-" + j/3))
                     return false;
                }
            }
        }
        return true;
    }
}
