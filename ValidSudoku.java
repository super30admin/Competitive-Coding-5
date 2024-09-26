// Time and Space O(1) since the size of the sudoku board is fixed.

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i =0;i<9;i+=3)
        {
            for(int j=0;j<9;j+=3)
            {    
                if(!checkBox(i,j,board))
                { 
                    return false;  }
            }
        }
        
        for(int i=0;i<9;i++)
        {
            if(!checkRow(i,board))
                return false;
        }
        
        for( int i=0;i<9;i++)
        {
            if(!checkColumn(i,board))
                return false;
        }
        
        return true;
        
    }
    private boolean checkBox(int i , int j , char[][]board)
    {
        HashSet<Character> h = new HashSet<>();
        
        for(int l = 0;l<3;l++)
        {for(int m = 0;m<3;m++)
        {   
            if(h.contains(board[i+l][j+m]))
                return false;
            if(Character.isDigit(board[i+l][j+m]))
            h.add(board[i+l][j+m]);
        }
         
         
         }
        
        return true;
       
    }
    
    private boolean checkRow(int i , char[][]board)
    {   HashSet<Character> h = new HashSet<>();
        for( int j =0;j<9;j++)
        { if(h.contains(board[i][j]))
            return false;
         if(Character.isDigit(board[i][j]))
          h.add(board[i][j]);
        }
     return true;
    }
    
    private boolean checkColumn(int i, char[][]board)
    {
        HashSet<Character> h = new HashSet<>();
        for(int j=0;j<9;j++)
        {
            if(h.contains(board[j][i]))
                return false;
            if(Character.isDigit(board[j][i]))
            h.add(board[j][i]);
        }
        return true;
    }
    
    
    
}