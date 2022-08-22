//TC = mn + mn + m^2n = O(m^2n);


class Solution {
    public boolean isValidSudoku(char[][] board) {
        //Given char 2D-array
        
        //check all rows for unique values
        for(int i=0; i<9; i++){
            //declare boolean array for each row stores t/f
            boolean[] b = new boolean[9];
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'){
                    if(b[(int)(board[i][j]-'1')]) return false;
                    b[(int)(board[i][j]-'1')] = true;
                }
                
            }
        }
        
        //check all cols for unique values
        for(int j=0; j<9; j++){
            //declare boolean array for each row stores t/f
            boolean[] b = new boolean[9];
            for(int i=0; i<9; i++){
                if(board[i][j]!='.'){
                    if(b[(int)(board[i][j]-'1')]) return false;
                    b[(int)(board[i][j]-'1')] = true;
                }
                
            }
        }
        
        
        //check for all the 9 grids 3*3 
        
        //0 1 2
        //3 4 5
        //6 7 8
        
        for(int grid = 0; grid < 9; grid ++){ //loop all the 9 grids 
            boolean[] b = new boolean[9];
            for(int i = grid/3*3; i< grid/3*3+3; i++){
                for(int j=grid%3*3; j< grid%3*3+3; j++){
                    if(board[i][j]!='.'){
                    if(b[(int)(board[i][j]-'1')]) return false;
                    b[(int)(board[i][j]-'1')] = true;
                 }
              }
            }
        }
        
        return true;
    }
}
