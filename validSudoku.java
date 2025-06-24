//temporarily removing the current digit, validating its position using the isTrue method, and restoring it afterward.
//Time complexity: O(1)
//Space complexity: O(1)

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
    for(int i=0;i<9;i++)
    {
        for(int j=0;j<9;j++)
        {
            if(board[i][j]=='.') continue;
            char num= board[i][j];
            board[i][j]='.';
            if(isTrue(board, i, j, num)==false) return false;
            board[i][j]=num;
            
        }
    }
    return true;
    }
     public boolean isTrue(char[][] board, int row, int col, char num)
    {
        for(int j=0;j<9;j++)
        {
            if(board[row][j]==num) return false;
        }

        for(int i=0; i<9;i++)
        {
            if(board[i][col]==num) return false;  
        }
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++)
        {
            for(int j=sc;j<sc+3;j++)
            {
                if(board[i][j]==num) return false;
            }
        }
        return true;
    }
}