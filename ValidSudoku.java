
// Time Complexity :O(1)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {  
    public boolean isValidSudoku(char[][] board) {  
        if(board == null || board.length != 9 || board[0].length != 9) return false;  
          
        for(int i = 0; i < 9; i++){  
            boolean[] b = new boolean[9];  
              
            for(int j = 0; j < 9; j++){  
                if(board[i][j] != '.')  
                {  
                    int num = Character.getNumericValue(board[i][j]);  
                    if(b[num - 1]) return false;  
                    b[num - 1] = true;  
                }  
            }  
        }  
          
        for(int k = 0; k < 9; k++){  
            boolean[] b = new boolean[9];  
              
            for(int l = 0; l < 9; l++){  
                if(board[l][k] != '.')  
                {  
                    int num = Character.getNumericValue(board[l][k]);  
                    if(b[num - 1]) return false;  
                    b[num - 1] = true;  
                }  
            }  
        }  
          
        for(int block = 0; block < 9; block++){  
            boolean[] b = new boolean[9];  
              
            for(int m = block / 3 * 3; m < block / 3 * 3 + 3; m++){  
                for(int n = block % 3 * 3; n < block % 3 * 3 + 3; n++){  
                    if(board[m][n] != '.')  
                    {  
                        int num = Character.getNumericValue(board[m][n]);  
                        if(b[num - 1]) return false;  
                        b[num - 1] = true;  
                    }  
                }  
            }  
        }  
          
        return true;          
    }  
}  
