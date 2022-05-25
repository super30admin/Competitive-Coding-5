//TC : O(N^2)

//SC : O(N) - Using 3 1D arrays


class Solution {
    public boolean isValidSudoku(char[][] board) {

        int n = board.length;
        if(board == null || board.length == 0)  return true;
        
        for(int i = 0; i < n; i++){
            boolean[] arr = new boolean[n];
            
            for(int j = 0; j< n ; j++){
                if(board[i][j] != '.'){
                    int ix = (int)(board[i][j] - '1');
                    if( arr[ix] )   return false;
                    
                    arr[ix] = true;
                }
            }
        }
        
        for(int j = 0; j < n; j++){
            boolean[] arr = new boolean[n];
            
            for(int i = 0; i< n; i++){
                if(board[i][j] != '.'){
                    int ix = (int)(board[i][j] - '1');
                    if( arr[ix] )   return false;
                    
                    arr[ix] = true;
                }
            }
        }
        
        
        for(int i = 0; i < n; i++){ // Checking for 2D Blocks of size  3 * 3
            boolean[] arr = new boolean[n];
            
            for(int x = i/3 * 3; x< i/3 * 3 + 3; x++){
                for(int y = i%3 * 3; y< i%3 * 3 + 3; y++){
                    if(board[x][y] != '.'){
                        int ix = (int)(board[x][y] - '1');
                    if( arr[ix] )   return false;
                    
                    arr[ix] = true;
                    }
                }
            }
        }
        
        return true;
        
    }
}