
//Time Complexity : O(n^2)
//Space Complexity : O(n)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        if(board == null || board.length<=0){
            return false;
        }
        
        Set<Integer>[] rows = new HashSet[9];
        Set<Integer>[] cols = new HashSet[9];
        Set<Integer>[] grid = new HashSet[9];
        
        for(int i=0; i<9;i++){
            rows[i] = new HashSet<Integer>();
            cols[i] = new HashSet<Integer>();
            grid[i] = new HashSet<Integer>();
        }
        
        
        for(int i=0; i<9; i++){
          
            for(int j=0; j<9; j++){
                
                char num = board[i][j];
                if(num!='.'){
                    int n = (int)num;
                    int grid_index = (i/3)*3 + j/3;
                    
                    if(rows[i].contains(n) || cols[j].contains(n) || grid[grid_index].contains(n)){
                         return false;
                    }
                    rows[i].add(n);
                    cols[j].add(n);
                    grid[grid_index].add(n);
                   
                }
            }
        }
        
        
        return true;
        
    }
}