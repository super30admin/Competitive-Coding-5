/**
Time Complexity : O(M*N)
Space Complexity : O(M*N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/

class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
        
        
        Set<String> hashSet = new HashSet<>();
        
        for( int i =0 ;i< 9; i++)
        {
            
            for( int j =0 ; j < 9 ; j++)
            {
                
                if(board[i][j] != '.')
                {
                    
                String rowCheck = board[i][j] + "|" + i + "|";
                String colCheck = "|" + j + "|" + board[i][j];
                
                int rowIndex = i/3;
                int colIndex = j/3;
                
                String cellCheck = board[i][j] + "|" + rowIndex + "|" +colIndex;
                
                if( hashSet.contains(rowCheck) || hashSet.contains(colCheck) || hashSet.contains(cellCheck))
                    return false;
                else
                {
                    hashSet.add(rowCheck);
                    hashSet.add(colCheck);
                    hashSet.add(cellCheck);
                }
                }
            }
        }
        
        return true;
    }
}