// 36.

//time - O(n^3) if board is a n*n matrix - here its constant
//space - O(n) if board is a n*n matrix - here its constant

class Solution {
    public boolean isValidSudoku(char[][] board) {
       //edge
        if(board == null || board.length != 9 || board[0].length != 9)
        {
            return false;
        }
        
        //time - constant here but becomes O(n^2) if board is a n*n matrix
        //space - constant here but becomes O(n) if board is a n*n matrix
        //each row shoud have numbers from 1 to 9 with no duplicates
        //use a boolean array of size 9 to track elements in row
        for(int i = 0; i < 9; i++)
        {
            boolean[] row = new boolean[9];
            for(int j = 0; j < 9; j++)
            {
                if(board[i][j] != '.')
                {
                    int number = Character.getNumericValue(board[i][j]);
                    if(row[number - 1]) //number already present
                    {
                        return false;
                    }
                    row[number - 1] = true;
                }
            }
        }
        
        //time - constant here but becomes O(n^2) if board is a n*n matrix
        //space - constant here but becomes O(n) if board is a n*n matrix
        //each column shoud have numbers from 1 to 9 with no duplicates
        //use a boolean array of size 9 to track elements in column
        for(int i = 0; i < 9; i++)
        {
            boolean[] column = new boolean[9];
            for(int j = 0; j < 9; j++)
            {
                if(board[j][i] != '.')
                {
                    int number = Character.getNumericValue(board[j][i]);
                    if(column[number - 1]) // number already present
                    {
                        return false;
                    }
                    column[number - 1] = true;
                }
            }
        }
        
        //time - constant here but becomes O(n^3) if board is a n*n matrix
        //space - constant here but becomes O(n) if board is a n*n matrix
        //each grid shoud have numbers from 1 to 9 with no duplicates
        //use a boolean array of size 9 to track elements in grid
        for(int grid = 0; grid < 9; grid++)
        {
            boolean[] block = new boolean[9];
            int rowStart = (grid / 3) * 3;
            int colStart = (grid % 3) * 3;
            for(int i = rowStart; i < rowStart + 3; i++)
            {
                for(int j = colStart; j < colStart + 3; j++)
                {
                    if(board[i][j] != '.')
                    {
                        int number = Character.getNumericValue(board[i][j]);
                        if(block[number - 1])
                        {
                            return false;
                        }
                        block[number - 1] = true;
                    }
                }
            }
        }
        
        return true;
    }
}
