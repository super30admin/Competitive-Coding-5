class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
       for(int i=0;i<9;i++)
       {
            if(!isValidRow(board, i))
            {
                return false;
            }
       } 
       for(int i=0;i<9;i++)
       {
            if(!isValidColumn(board, i))
            {
                return false;
            }
       } 
       for(int i=0;i<9;i+=3)
       {
            for(int j=0;j<9;j+=3)
            {
            if(!isValidSubBox(board, i, j))
            {
                return false;
            }
            }
            
       }
       return true;
    }

    private boolean isValidColumn(char[][] board, int column)
    {
         HashSet<Character> s = new HashSet<>();
        for(int i=0;i<9;i++)
        {
            char ch = board[i][column];
            if(s.contains(ch) && ch!='.')
            return false;
            else
            s.add(ch);
        }
        return true;
    }
    private boolean isValidRow(char[][] board, int row)
    {
        HashSet<Character> s = new HashSet<>();
        for(int j=0;j<9;j++)
        {
            char ch = board[row][j];
            if(s.contains(ch) && ch!='.')
            return false;
            else
            s.add(ch);
        }
        return true;
    }

    private boolean isValidSubBox(char[][] board, int row, int column)
    {
        HashSet<Character> s = new HashSet<>();
        for(int i=row;i<row+3;i++)
        {
            for(int j=column;j<column+3;j++)
            {
            char ch = board[i][j];
            if(s.contains(ch) && ch!='.')
            return false;
            else
            s.add(ch);
            }
        }
        return true;
    }
}

//tc: O(1)
//sc: O(1)