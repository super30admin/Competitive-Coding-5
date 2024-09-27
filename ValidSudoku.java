class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9)
        {
            return false;
        }
          //row
        for(int i = 0 ; i<9 ; i++)
        {
            boolean isPresent [] = new boolean[9];
            
            for(int j = 0 ; j<9 ; j++)
            {
                if(board[i][j] != '.')
                {
                    if(isPresent[(int)(board[i][j]-'1')])
                    {
                        return false;
                    }
                    isPresent[(int)(board[i][j]-'1')] = true;
                }
            }
        } 
        //column
        for(int j = 0 ; j<9 ; j++)
        {
            boolean isPresent [] = new boolean[9];
            
            for(int i = 0 ; i<9 ; i++)
            {
                if(board[i][j] != '.')
                {
                    if(isPresent[(int)(board[i][j]-'1')])
                    {
                        return false;
                    }
                    isPresent[(int)(board[i][j]-'1')] = true;
                }
            }
        }        
        //block        
        for(int block = 0 ; block<9 ; block++)
        {
            boolean isPresent[] = new boolean[9];
            for(int i = block/3*3 ; i<block/3*3+3 ; i++)
            {
                for(int j = block%3*3 ; j<block%3*3+3 ; j++)
                {
                    if(board[i][j] != '.')
                    {
                        if(isPresent[(int)(board[i][j]-'1')])
                        {
                            return false;
                        }
                        isPresent[(int)(board[i][j]-'1')] = true;
                    }
                }
            }
        }
        return true;   
    }
}

//Time complexity - O(1) since number of cells 81 is fixed
//Space complexity - O(1) 
