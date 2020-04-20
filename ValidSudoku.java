//Time complexity: O(M*N)
//Space complexity: O(M*N)

import java.util.*;
class SudokuSolution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen=new HashSet<>();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]!='.')
                {
                    if(!seen.add(board[i][j]+" row value "+ i))
                        return false;
                    if(!seen.add(board[i][j]+" column value "+ j))
                        return false;
                    if(!seen.add(board[i][j]+" box value "+i/3+"-"+j/3))
                        return false;
                }
            }
        }
        return true;
    }
}