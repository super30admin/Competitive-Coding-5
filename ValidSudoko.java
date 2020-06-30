//Time and space complexity: O(1) as constant board size

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> seen = new HashSet();
        
        for(int i = 0; i < board.length; i++){                     
            for(int j = 0; j < board[0].length; j++){
                char curr_val = board[i][j];
                if(curr_val != '.'){
                    if(!seen.add(curr_val + "found in row" + i) ||
                       !seen.add(curr_val + "found in coloumn" + j) || 
                       !seen.add(curr_val + "found in sub box" + i/3 + "-" + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}