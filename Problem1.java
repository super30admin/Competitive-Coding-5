// Time Complexity : O(1) traverses through whole matrix but since we know the size of matrix will always be constant
// Space Complexity : O(1) since our boolean array will always only store upto 9 values
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    public boolean isValidSudoku(char[][] board) {
        if(board.length != 9 || board[0].length != 9 || board == null){
            return false;
        }

        //check all rows
        for(int i = 0; i < 9; i++){
            boolean[] digit = new boolean[9];
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(digit[(int)(board[i][j] - '1')] == true){
                        return false;
                    }
                    else{
                        digit[(int)(board[i][j] - '1')] = true;
                    }
                }
            }
        }

        //check all col
        for(int j = 0; j < 9; j++){
            boolean[] digit = new boolean[9];
            for(int i = 0; i < 9; i++){
                if(board[i][j] != '.'){
                    if(digit[(int)(board[i][j] - '1')] == true){
                        return false;
                    }
                    else{
                        digit[(int)(board[i][j] - '1')] = true;
                    }
                }
            }
        }

        //check the blocks
        //check all rows
        for(int block = 0; block < 9; block++){
            boolean[] digit = new boolean[9];
            for(int i = block/3*3; i < block/3*3+3; i++){
                for(int j = block%3*3; j < block%3*3+3; j++){
                    if(board[i][j] != '.'){
                        if(digit[(int)(board[i][j] - '1')] == true){
                            return false;
                        }
                        else{
                            digit[(int)(board[i][j] - '1')] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}
