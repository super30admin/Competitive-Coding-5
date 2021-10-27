// Time Complexity :o(n^2)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : took more time to pass all cases.


// Your code here along with comments explaining your approach:- taking 3 hashsets one hasset for column checking
// one for row and another for box. iterating in that directions and checking if element present in board but not in hashsets
// adding them to hashset if element found in hashset is there in board returning false.

class Solution {
    public boolean isValidSudoku(char[][] board) {
         for(int i=0; i<board.length; i++){
            HashSet<Character> hs = new HashSet<>();
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == '.')
                    continue;
                else if(hs.contains(board[i][j]))
                    return false;
                else
                    hs.add(board[i][j]);
            }
        }
        
        for(int j=0; j<board[0].length; j++){
            HashSet<Character> hs = new HashSet<>();
            for(int i=0; i<board.length; i++){
                if(board[i][j] == '.')
                    continue;
                else if(hs.contains(board[i][j]))
                    return false;
                else
                    hs.add(board[i][j]);
            }
        }
        
        
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
               HashSet<Character> hs = new HashSet<>();
               for(int row=i; row<i+3; row++){
                   for(int col=j; col<j+3; col++){
                       if(board[row][col] == '.')
                           continue;
                       else if(hs.contains(board[row][col]))
                           return false;
                       else
                           hs.add(board[row][col]);
                   }
               }
            }
        }
        return true;
        
        
}
}