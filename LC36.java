class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> seen = new HashSet<>();
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char curr = board[i][j];
                if(curr != '.'){
                    if(!seen.add(curr + " found in row " + i) || 
                      !seen.add(curr + " found in column " + j) ||
                       !seen.add(curr + " found in box where " + "i = " + i/3 + " j = " + j/3)
                      ){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

//Time : O(1) as constant board size
//space : O(1) as constant board size