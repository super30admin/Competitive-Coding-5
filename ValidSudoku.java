// TC : O(m*n) where m is the rows and n is the columns
// SC : O(1)

import java.util.HashSet;
import java.util.Set;

// Approach 1
class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length ==0 || board[0].length == 0)
            return false;

        //row
        for(int i = 0 ; i < 9 ; i++){
            boolean[] b = new boolean[9];
            for(int j = 0 ; j < 9 ; j++){
                if(board[i][j] != '.'){
                    if(b[(int)(board[i][j] - '1')])
                        return false;
                    b[(int)(board[i][j] -'1')] = true;
                }
            }
        }

        //column
        for(int j = 0 ; j < 9 ; j++){
            boolean[] b = new boolean[9];
            for(int i = 0 ; i < 9 ; i++){
                if(board[i][j] != '.'){
                    if(b[(int)(board[i][j] - '1')])
                        return false;
                    b[(int)(board[i][j] -'1')] = true;
                }
            }
        }

        //block
        for(int block = 0 ; block < 9 ; block ++){
            boolean[] b = new boolean[9];

            for(int i = block /3*3 ; i < block/3*3+3 ; i++){
                for(int j = block%3*3 ; j < block%3*3+3 ; j++){
                    if(board[i][j] != '.'){
                        if(b[(int)(board[i][j] - '1')]){
                            return false;
                        }
                        b[(int)(board[i][j] -'1')] = true;
                    }
                }
            }
        }
        return true;
    }
}

// Approach 2

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }
}