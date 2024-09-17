//time- O(n*m)
//space- O(n*m)

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Set<String> hs= new HashSet<>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                
                char val= board[i][j];
                if(val!='.'){
                        if( !hs.add(val + "row is"+ i) || !hs.add(val +"col is"+ j) || !hs.add(val+"found in sub-grid"+ i/3+ "-"+ j/3))
                       return false;
                   }
                }
            }
        return true;
        }
        
}