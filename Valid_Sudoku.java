// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null||board.length==0||board[0].length==0){
            return false;
        }
        
        //For row
        for(int i=0;i<9;i++){
            boolean[] b = new boolean[9];
            for(int j=0;j<9;j++){
               if(board[i][j]!='.'){
                   if(b[(int)(board[i][j]-'1')]){
                       return false;
                   }
                   b[(int)(board[i][j]-'1')]=true;
               } 
            }
        }
        
        //For column
        for(int j=0;j<9;j++){
            boolean[] b = new boolean[9];
            for(int i=0;i<9;i++){
               if(board[i][j]!='.'){
                   if(b[(int)(board[i][j]-'1')]){
                       return false;
                   }
                   b[(int)(board[i][j]-'1')]=true;
               } 
            }
        }
        
        //For block
        for(int block=0;block<9;block++){
            boolean[] b = new boolean[9];
                for(int i=block/3*3;i<block/3*3+3;i++){
                    for(int j=block%3*3;j<block%3*3+3;j++){
                        if(board[i][j]!='.'){
                            if(b[(int)(board[i][j]-'1')]){
                                return false;
                            }
                        b[(int)(board[i][j]-'1')]=true;
                        } 
                    }
                }
        }
        
        return true;
    }
}