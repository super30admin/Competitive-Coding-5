// Time Complexity : O(9*9*(9+9+9))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// For each value in input matrix, perform row level, column level and box level validations
class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0; j<board[0].length;j++){
                if(board[i][j]!='.'){
                    if(!isValidHelper(board,i,j))
                        return false;
                }
            }
        }
        return true;
    }

    private boolean isValidHelper(char[][] board,int i, int j){
        char val = board[i][j];

        //check for row
        for(int k=0;k<9;k++){
            if(k!=j){
                if(board[i][k]==val)
                    return false;
            }
        }

        //check for column
        for(int l=0;l<9;l++){
            if(l!=i){
                if(board[l][j]==val)
                    return false;
            }
        }

        //check for current box
        int boxRow = i;
        int boxCol = j;
        while(boxRow%3>0)
            boxRow--;
        while(boxCol%3>0)
            boxCol--;
        for(int m=boxRow;m<boxRow+3;m++){
            for(int n=boxCol;n<boxCol+3;n++){
                if(m==i && n==j){}
                else{
                    if(board[m][n]==val)
                        return false;
                }
            }
        }
        return true;
    }
}
