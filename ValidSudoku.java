/** 
Problem: Check if the given sudoku board is valid
Did it run on LeetCode: Yes

Time Complexity: O(1),(just 81 cells)
Space Complexity :O(1)

Approach:
1. We need to check that there are no repeated elements in every row, every column, and every block.
2. For the same purpose, we keep a boolean array, which basically is used to keep track of the visited elements.
3. If at any point, we find a repeated element, we return false as it's not a valid sudoku then.

*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        //Row
        for(int i=0; i<9; i++) {
            boolean[] boolArray = new boolean[9];
            for(int j = 0; j<9; j++) {
                if(board[i][j] != '.') {
                    if(boolArray[(int) (board[i][j] - '1')]) {
                        return false;
                    }
                    boolArray[(int)(board[i][j] - '1')] = true;
                }
            }
        }
        //Column
        for(int j=0; j<9; j++) {
            boolean[] boolArray = new boolean[9];
            for(int i = 0; i<9; i++) {
                if(board[i][j] != '.') {
                    if( boolArray[(int)(board[i][j] - '1')]) {
                        return false;
                    }
                     boolArray[(int)(board[i][j] - '1')]= true;
                }
            }
        }
        
        //Block
        for(int block = 0; block < 9; block++) {
            boolean[] blockArray = new boolean[9];
            for(int i = (block/3)*3 ; i < ((block/3)*3)+3; i++) {
                for(int j = (block%3)*3 ; j < ((block%3)*3)+3; j++) {
                    if(board[i][j] != '.') {
                    if(blockArray[(int) board[i][j] - '1']) {
                        return false;
                    }
                    blockArray[(int) board[i][j] - '1'] = true;
                }
            }
        }
    }
         return true;
    }
   
}