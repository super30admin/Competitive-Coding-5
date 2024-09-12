// Time complexity - O(1)
// Space complexity - O(1)


class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int  i = 0 ; i < board.length; i++){
            for(int j= 0; j < board[0].length; j++){
                char c = board[i][j];
                if(c != '.'){
                    if(seen.contains(c + " at row " + i) || seen.contains(c + " at column " + j) 
                      || seen.contains(c + " at sub box " + i/3 +"-"+ j/3)
                      ){
                       return false; 
                    }else{
                    seen.add(c + " at row " + i);
                    seen.add(c + " at column " + j);
                    seen.add(c + " at sub box " + i/3 +"-"+ j/3);
                    }
                }   
            }
        }
        return true;
    }
}
