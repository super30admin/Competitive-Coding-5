//Time Complexity: O(1) remains constant
//Space Complexity: O(1)
//Was able to solve completely during mock interview
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++)
        {
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> cols = new HashSet<Character>();
            HashSet<Character> squares = new HashSet<Character>();
            for(int j=0; j<9; j++)
            {
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                {
                    return false;
                }
                if(board[j][i]!='.' && !cols.add(board[j][i]))
                {
                    return false;
                }
                int rowIndex= 3*(i/3);
                int colIndex = 3*(i%3);
                if(board[rowIndex+j/3][colIndex+j%3]!='.' && !squares.add(board[rowIndex+j/3][colIndex+j%3]))
                {
                    return false;
                }
            }
            
        }
        return true;
    }
}