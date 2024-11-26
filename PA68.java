//Leetcode 36. Valid Sudoku
//Time Complexity : O(m*n) 
//Space Complexity: O(n^2) // O(n*row+ n*col+ n*blocks), not sure
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] ar; 
        //row
        for(int i=0; i<board.length;i++){
            ar= new boolean[9]; 
            for(int j=0;j<board[0].length;j++){              
                if(board[i][j] !='.' ){
                    if(ar[board[i][j]-'1']){                        
                        return false;
                    }
                ar[board[i][j]-'1']=true;
                }
            }
        } 
        
        //col
        for(int i=0; i<board[0].length;i++){
             ar= new boolean[9];
            for(int j=0;j<board.length;j++){
                if(board[j][i] !='.' ){
                    if(ar[board[j][i]-'1']){                       
                        return false;
                    }
                ar[board[j][i]-'1']=true;
                }
            }
        } 
        //block
        for(int b=0; b<9; b++){
             ar= new boolean[9]; 
            for(int i=(b/3)*3; i<(b/3)*3+3;i++){            
                for(int j=(b%3)*3;j<(b%3)*3+3;j++){                    
                    if(board[i][j] !='.'  ){                    
                        if(ar[board[i][j]-'1']){
                            return false;
                        }
                     ar[board[i][j]-'1']=true;
                    }
                }
            }
        }
       
        return true;
    }
}