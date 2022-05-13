import java.util.HashSet;

class validSudoku {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> seen = new HashSet<>();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                char curr = board[i][j];
                if(curr != '.'){
                    if(!seen.add(curr + "found in row" + i) ||
                        !seen.add(curr + "found in col" + j) ||
                        !seen.add(curr + "found in sub boxes" + i/3 + "-" + j/3))
                       
                       return false;
                }
            }
        }
         return true;              
    }
}

//time complexity O(n^2)
//space complexity O(n) where n is number of row/col