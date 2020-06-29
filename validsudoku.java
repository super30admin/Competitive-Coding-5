//Time and space complexity: O(1) as constant board size

class Solution {
    public boolean isValidSudoku(char[][] board) {
         if(board == null || board.length!=9 || board[0].length != 9) return false;
 
         HashSet<String> set= new HashSet<>();
 
         for(int i = 0; i < board.length ; i ++)
         {
             for(int j = 0 ; j < board[0].length ; j++)
             {
                 if(board[i][j]!='.')
                 {
                     if(!set.add(board[i][j] + "is in row " + i )
                             || !set.add(board[i][j] + "is in column " + j)
                             || !set.add(board[i][j] + "is in grid" + i/3 +"and"+ j/3))
                     {
                         return false;
                     }
                 }
             }
         }
         return true;
    }
 }