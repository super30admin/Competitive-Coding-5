/*time complexity O(1)
space complexity O(n) for n*n sudoku we are creating boolean array of size n */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length!=9 ||board[0].length!=9) return false;
        //row 
        for(int i=0;i<9;i++){
            boolean[] b=new boolean[9];
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(b[(int)board[i][j]-'1']){
                        return false;
                    }
                    b[(int)board[i][j]-'1']=true;
                }
            }
        }
        //column
        for(int i=0;i<9;i++){
            boolean[] b=new boolean[9];
            for(int j=0;j<9;j++){
                if(board[j][i]!='.'){
                    if(b[(int)board[j][i]-'1']){
                        return false;
                    }
                    b[(int)board[j][i]-'1']=true;
                }
            }
        }
        //block
        for(int i=0;i<9;i++){
            boolean[] b=new boolean[9];
            for(int j=i/3*3;j<i/3*3+3;j++){
                for(int k=i%3*3;k<i%3*3+3;k++){
                    if(board[j][k]!='.'){
                    if(b[(int)board[j][k]-'1']){
                        return false;
                    }
                    b[(int)board[j][k]-'1']=true;
                }
            }
        }
      }
       return true; 
    }
        
}