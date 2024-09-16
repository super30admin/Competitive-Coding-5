// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


//validate sudoku
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.'){
                    if(!validate(board,i,j,board[i][j])){
                        //System.out.println(i+","+j);
                        return false;
                    }
                }
            }
        }
        
        
        return true;
    }
    
    private boolean validate(char[][] board,int row,int col,char val){
        //validatig the row
        for(int j=0;j<board[0].length;j++){
            if(board[row][j]==val && col!=j){
                //System.out.println("ji");
                return false;
            }
        }
        
        //validating the column
        for(int i=0;i<board[0].length;i++){
            if(board[i][col]==val && row!=i){
                return false;
            }
        }
        
        //validating the smaller matrix
        int rows=3*(row/3);
        int cols=3*(col/3);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[rows+i][cols+j]==val && row!=(rows+i) && col!=(cols+j)){
                    return false;
                }
            }
        }
        return true;
        
    }
}


















//sudoku solver
class Solution {
    private char[][] track;
    public void solveSudoku(char[][] board) {
        track=new char[board.length][board[0].length];
        sudokuHelper(board,0,0);
        for(int i=0;i<track.length;i++){
            for(int j=0;j<track[i].length;j++){
                board[i][j]=track[i][j];
            }
        }

        
    }
    
    private void sudokuHelper(char[][] board,int row,int col){
        if(row==board.length){
            for(int i=0;i<track.length;i++){
                for(int j=0;j<track[i].length;j++){
                    track[i][j]=board[i][j];
                }
            }
            return;
        }
        int i=0;
        int j=0;
        
        if(col==board[0].length-1){
            i=row+1;
            j=0;
        }else{
            i=row;
            j=col+1;
        }
        
        if(board[row][col]=='.'){
            for(int po=1;po<=9;po++){
                if(validate(board,row,col,po)){
                    board[row][col]=(char)('0'+po);
                    sudokuHelper(board,i,j);
                    board[row][col]='.';
                }
            }
            
        }else{
            sudokuHelper(board,i,j);
        }
    }
    
    private boolean validate(char[][] board,int row,int col,int val){
        //validatig the row
        for(int j=0;j<board[0].length;j++){
            if(board[row][j]==((char)('0'+val))){
                return false;
            }
        }
        
        //validating the column
        for(int i=0;i<board[0].length;i++){
            if(board[i][col]==((char)('0'+val))){
                return false;
            }
        }
        
        //validating the smaller matrix
        int rows=3*(row/3);
        int cols=3*(col/3);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[rows+i][cols+j]==((char)('0'+val))){
                    return false;
                }
            }
        }
        return true;
        
    }
}