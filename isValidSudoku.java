// Time Complexity : O(1)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxs = new HashSet[9];
        
        for(int i = 0; i < 9 ; i++) {
            
            rows[i] = new HashSet();
            cols[i] = new HashSet();
            boxs[i] = new HashSet();
            
        }
        
        
        for(int i = 0;i<9;i++) {
            
            for(int j=0;j<9;j++) {
                
                if(board[i][j]=='.') continue;
                
                // validate row
                if(rows[i].contains(board[i][j])) 
                    return false;
                else rows[i].add(board[i][j]);
                
                // validate column
                if(cols[j].contains(board[i][j])) 
                    return false;
                else cols[j].add(board[i][j]);
                
                
                // validate box
                int box = 3*(i/3)+(j/3);
                if(boxs[box].contains(board[i][j])) 
                    return false;
                else boxs[box].add(board[i][j]);
                
            }
            
        }
        
        return true;
    }
}
