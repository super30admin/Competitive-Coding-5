// Time Complexity : O(m*n) m = number of rows, n = number of columns
// Space Complexity : O(1) for the boolean array of size 9
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        if(board == null || board.length != 9 || board[0].length != 9) return false;
        
        //check the row if it contains duplicates or not
        
        for(int i = 0;i < 9;i++){
            boolean b[] = new boolean[9];
            
            for(int j = 0;j < 9; j++){
                
                if(board[i][j] != '.'){
                    
                    if(b[board[i][j]-'1']) return false;
                    b[board[i][j]-'1'] = true;
                    
                }
            }
        }
        
        //check for the elements in the column whether it contains duplicate or not
        
        for(int j = 0;j < 9; j++){
            
            boolean b[] = new boolean[9];
            
            for(int i = 0;i < 9; i++){
                
                if(board[i][j] != '.'){
                    
                    if(b[board[i][j]-'1']) return false;
                    b[board[i][j]-'1'] = true;
                    
                }
            }
        }
        
        
        //check for the block of size 3 * 3 whether it contains duplicate or not
        
        for(int blk = 0; blk < 9; blk++){
            
            boolean b[] = new boolean[9];
            
            for(int i = blk/3*3; i < blk/3*3 + 3; i++){
                
                for(int j = blk%3*3; j < blk%3*3 + 3; j++){
                    
                    if(board[i][j] != '.'){
                        
                        if(b[board[i][j]-'1']) return false;
                        b[board[i][j]-'1'] = true;
                    
                    }
                }
            }
        }
        
        return true;
    }
}
