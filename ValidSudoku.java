/*
This program checks for the valid sudoku in three steps. In the first step it checks if all the rows are valid, in
the second step it checks if all the columns are valid, and in the final step it checks if all the blocks are valid.
We use a hash set to keep track of the validity, by adding numbers in a given row/column/block, since the hash set 
will always contain unique values and can be used to check if duplicate value is being passed.

Did this code run on leetcode: Yes
*/
class Solution {
    //Time Complexity: O(1) since sudoku is always a 9x9 matrix
    //Space Complexity: O(1) since hash set only tracks 9 values
    public boolean isValidSudoku(char[][] board) {
        
        if(board == null || board.length == 0)
            return false;
        
        HashSet<Character> set = new HashSet();
        
        //Row processing
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {   
                if(board[i][j] != '.')
                {
                    if(!set.contains(board[i][j]))
                        set.add(board[i][j]);
                    
                    else
                        return false;
                }        
                
            }
            set.clear();
                
        }
            
        //Column processing
        for(int j = 0; j < 9; j++)
        {
            for(int i = 0; i < 9; i++)
            {
                
                if(board[i][j] != '.')
                {
                    if(!set.contains(board[i][j]))
                        set.add(board[i][j]);
                    
                    else
                        return false;
                }
            }
            set.clear();
        }
        
        //Block processing
        for(int i = 0; i < 9; i = i + 3)
        {
            for(int j = 0; j < 9; j = j + 3)
            {
                for(int k = i; k < i + 3; k++)
                {
                    for(int l = j; l < j + 3; l++)
                    {
                        if(board[k][l] != '.')
                        {
                            if(!set.contains(board[k][l]))
                                set.add(board[k][l]);

                            else
                                return false;
                        }   
                    }
                }
                set.clear();
            }
        }
                
        
        return true;
        
    }
}