
// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode: yes
// Any problem you faced while coding this: Yes, got with a string


// Your code here along with comments explaining your approach
/*Approach
1) In this we have a hashset, where we store the row visits, column visits and the character which exists on that particular row and column.
2) we take the sqaure root of board and we just iterate only till the value.
3) if its a '.' we just continue, if its a number we need to check if it exists in row, column or the block
*/



class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        
        if(board==null || board.length!=9 || board[0].length!=9)
        {
            return false;
        }
        
        Set<String> set = new HashSet<>();
        
        int len = (int)Math.sqrt(board.length);
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                
                if(board[i][j]!='.')
                {
                    char number = board[i][j];
                    
                    if(set.contains("number:"+number+"in row:"+i) || set.contains("number:"+number+"in col:"+j) || set.contains("number"+number+"in row"+i/3+"in col"+j/3))
                    {
                        return false;
                    }
                    
                    set.add("number:"+number+"in row:"+i);
                    set.add("number:"+number+"in col:"+j);
                    set.add("number"+number+"in row"+i/3+"in col"+j/3);
                    
                }
                
            }
        }
        
        return true;
    }
}