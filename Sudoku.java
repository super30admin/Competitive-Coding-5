
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                boolean result = checkValid(board, i, j);
                if(!result) 
                    return false;
            }
        }
        return true;
    }
    
    private boolean checkValid(char[][] arr, int row, int col){
        if(arr[row][col] == '.') 
            return true;
        
        int start_i = (row / 3)*3;
        int start_j = (col / 3)*3;

        for(int i = start_i; i < start_i + 3; i++){
            for(int j = start_j; j < start_j + 3; j++){
                if(row == i && col == j) 
                    continue;
                if(arr[row][col] == arr[i][j]) 
                    return false;
            }
        }

        for(int i = 0; i < 9; i++){
            if(col == i) 
                continue;
            if(arr[row][i] == arr[row][col]) 
                return false;
        }

        for(int i = 0; i < 9; i++){
            if(row == i) 
                continue;
            if(arr[i][col] == arr[row][col]) 
                return false;
        }

        return true;
      }
}