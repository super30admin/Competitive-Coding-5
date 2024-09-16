// Time Complexity: O(1)
// Space COmplexity: O(1)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length !=9 || board[0].length != 9) {
            return false;
        }

        // Checking rows
        for(int i = 0; i < 9; i++) {
            boolean[] b = new boolean[9];

            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    if(b[board[i][j] - '1']) {
                        return false;
                    }
                    b[board[i][j] - '1'] = true;
                }
            }

        }

        // Checking columns
        for(int i = 0; i < 9; i++) {
            boolean[] b = new boolean[9];

            for(int j = 0; j < 9; j++) {
                if(board[j][i] != '.'){
                    if(b[board[j][i] - '1']) {
                        return false;
                    }
                    b[board[j][i] - '1'] = true;
                }
            }

        }

        // Checking blocks of squares
        for(int block=0; block < 9; block++) {
            boolean[] b = new boolean[9];

            for(int i=block/3*3; i<block/3*3+3; i++) {
                for(int j=block%3*3; j<block%3*3+3; j++) {
                    if(board[i][j] != '.'){
                        if(b[board[i][j] - '1']) {
                            return false;
                        }
                        b[board[i][j] - '1'] = true;
                    }
                }
            }
        }
        return true;
    }
}