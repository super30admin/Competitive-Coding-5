// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    
    public boolean isValidSudoku(char[][] board) {
        
        Set<String> visited = new HashSet<>();
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                
                char val = board[i][j];
                
                if(val == '.') continue;
                
                int gridNumber = (i / 3) * 3 + (j / 3);
                
                String row = "row" + i + val;
                String col = "col" + j + val;
                String grid = "grid" + gridNumber + val;
                
                if(visited.contains(row) || visited.contains(col) || visited.contains(grid)) {
                    return false;
                }
                
                visited.add(row);
                visited.add(col);
                visited.add(grid);
            }
        }
        return true;
    }
}