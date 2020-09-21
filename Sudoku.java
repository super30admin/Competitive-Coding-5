// Time Complexity :O(1)--> O(N^N) given that N=9
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :The block part was not intuitive, had to watch S30's video

// Your code here along with comments explaining your approach
// Check along each row for duplicates.
//Check along each column for duplicates.
//Check for the block if dupliactes exist.

import java.util.*;

class Sudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board.length == 0 || board == null)
            return false;

        int row = board.length;
        int col = board[0].length;
        // Row
        for (int i = 0; i < row; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            for (int j = 0; j < col; j++) {

                if (board[i][j] == '.') continue;
                    if (rowSet.contains(board[i][j]))
                        return false;
                    else
                        rowSet.add(board[i][j]);

                
            }
        }
        // column
        for (int j = 0; j < col; j++) {
            HashSet<Character> colSet = new HashSet<>();
            for (int i = 0; i < row; i++) {

                if (board[i][j] == '.') continue;
                    if (colSet.contains(board[i][j]))
                        return false;
                    else
                        colSet.add(board[i][j]);
                
            }
        }
        // block
        for (int block = 0; block < 9; block++) {
            HashSet<Character> blockSet = new HashSet<>();
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {

                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (board[i][j] == '.') continue;
                        if (blockSet.contains(board[i][j]))
                            return false;
                        else
                            blockSet.add(board[i][j]);
                    

                }
            }
        }

        return true;
    }

    public static void main(String args[]) {
        Sudoku obj = new Sudoku();
        char[][] board = { { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
                { '.', '4', '.', '3', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
                { '8', '.', '.', '.', '.', '.', '.', '2', '.' }, { '.', '.', '2', '.', '.', '7', '.', '.', '.' },
                { '.', '1', '5', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
                { '.', '2', '.', '9', '.', '.', '.', '.', '.' }, { '.', ',', '4', '3', '.', '.', '.', '.', '.' } };

        System.out.print(obj.isValidSudoku(board));

    }
}