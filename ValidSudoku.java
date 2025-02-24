//The approach here is that we need to check for duplicates in each row, each column and in each block of 3*3 matrix.
//For checking at a row, column and a block, we take a visited array to mark a value as true in the visited array if it is present once. 
//If there is a duplicate found, we return false.
//Time Complexity: O(1) because we are looping through a matrix of size 9*9
//Space Complexity: O(1) because we are creating an extra space of size 9 always
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9){
            return false;
        }

        //row
        for(int i = 0; i<9; i++){
            boolean[] b = new boolean[9];
            for(int j = 0; j<9; j++){
                if(board[i][j] != '.'){
                    if(b[board[i][j] - '1']) return false;
                    b[board[i][j] - '1'] = true;
                }
            }
        }

        //column
        for(int j = 0; j<9; j++){
            boolean[] b = new boolean[9];
            for(int i = 0; i<9; i++){
                if(board[i][j] != '.'){
                    if(b[board[i][j] - '1']) return false;
                    b[board[i][j] - '1'] = true;
                }
            }
        }

        //block
        for(int block = 0; block<9; block++){
            boolean[] b = new boolean[9];
            for(int i = block/3*3; i<block/3*3 + 3; i++){
                for(int j = block%3*3; j< block%3*3 + 3; j++){
                    if(board[i][j] != '.'){
                    if(b[board[i][j] - '1']) return false;
                    b[board[i][j] - '1'] = true;
                }
                }
            }
        }
        return true;
    }
}