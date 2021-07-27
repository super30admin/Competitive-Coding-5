import java.util.HashSet;

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class validSudoku {
    public boolean isValidSudoku(char[][] board) {
        
        if(board == null || board.length != 9 || board[0].length != 9)
            return false;
        
        HashSet<String> visited = new HashSet<>();
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                
                
                if(board[i][j] != '.'){
                    
                    //for every number we visit, we add into the hashset 3 times: for the row, column & box
                    //if it is seen in the same row/col/box then the hashset add function would return false
                    if(!visited.add(board[i][j] + " seen at row " + i)
                        || !visited.add(board[i][j] + " seen at column " + j)
                        || !visited.add(board[i][j] + " seen at box " + i + "-" + j))
                        
                        return false;
                }
            }
        }
        
        return true;
    }
}