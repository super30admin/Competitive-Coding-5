
// Time Complexity : O(m*n)
// Space Complexity : O(3(m*n)) ->O(m*n)
// Did this code successfully run on Leetcode : Yes

import java.util.HashSet;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        HashSet<Character>[] rowSet= new HashSet[9];
        HashSet<Character>[] colSet = new HashSet[9];
        HashSet<Character>[] boxSet = new HashSet[9];

        for(int i=0; i<9; i++)
        {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(board[i][j]!='.')
                {
                    if(!rowSet[i].contains(board[i][j]))
                        rowSet[i].add(board[i][j]);
                    else
                        return false;
                }
                if(board[j][i]!='.' )
                {
                    if(!colSet[i].contains(board[j][i]))
                        colSet[i].add(board[j][i]);
                    else
                        return false;
                }
                int boxIdx = (i/3*3+j/3);
                if(board[i][j]!='.')
                {
                    if(!boxSet[boxIdx].contains(board[i][j]))
                        boxSet[boxIdx].add(board[i][j]);
                    else
                        return false;
                }
            }
        }

        return true;
    }
}
