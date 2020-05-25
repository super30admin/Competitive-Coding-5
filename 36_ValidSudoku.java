// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> setRows = new HashSet<>();
        Set<String> setCol = new HashSet<>();
        Set<String> setBlock = new HashSet<>();
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.')
                    continue;
                
                if(!setRows.add("row : " + i + " : " + board[i][j]) ||
                   !setCol.add("col : " + j + " : " + board[i][j]) ||
                    !setBlock.add("block : " + i/3 + " : "+ j/3+" : " + board[i][j]))
                        return false;
                  
                  
                
            }
        }
        return true;
    }
}