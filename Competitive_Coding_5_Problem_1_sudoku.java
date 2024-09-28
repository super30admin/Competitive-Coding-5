//Time Complexity: O(n*m) where n&m are rows and columns of sudoku board
//Space Complexity: O(3*n*m) We'll be storing 3 strings for each elements in the HashSet
//Runs succesfully on leetcode
//No problem

//Here we'll be storing 3 strings : column,row and the box
//If any element will get repeated


import java.util.HashSet;

public class Competitive_Coding_5_Problem_1_sudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length!=9 || board[0].length != 9) return false;

        HashSet<String> hs = new HashSet<>();

        for(int i = 0; i < board.length ; i ++)
        {
            for(int j = 0 ; j < board[0].length ; j++)
            {
                if(board[i][j]!='.')
                {
                    if(!hs.add(board[i][j] + "found in row " + i )
                            || !hs.add(board[i][j] + "found in column " + j)
                            || !hs.add(board[i][j] + "found in subbox " + i/3 +" "+ j/3))
                    {
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
