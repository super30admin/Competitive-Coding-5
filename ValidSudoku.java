//first validate the row and columns
//thereafter validate each block 

//TC: O(n^2)
//SC: O(1)



public class ValidSudoku {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            
            //checking if the array is null or rows or columns are less than 9
            if(board.length == 0 || board[0].length == 0 || board.length < 9 || board[0].length< 9)
            {
                return false;
            }
    
            //checking for rows
            //starting with each, row, check if the element already marked as true is repeated in 
            //boolean array
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
    
            //check for every block
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
}
