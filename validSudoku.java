// Time Complexity : O(m*n)
// Space Complexity : 81 * 3 = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Some test cases and types


// Your code here along with comments explaining your approach

class Solution {
    
    public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length==0)
            return true;
        
        HashMap<Integer,HashSet<Integer>> row_hm=new HashMap<>();
        HashMap<Integer,HashSet<Integer>> column_hm=new HashMap<>();
        HashMap<Integer,HashSet<Integer>> grid_hm=new HashMap<>();
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                int row=i;
                int column=j;
                int grid=setGrid(i,j);
                
                if(!row_hm.containsKey(row))
                    row_hm.put(row,new HashSet<>());
                
                if(!column_hm.containsKey(column))
                    column_hm.put(column,new HashSet<>());
                
                if(!grid_hm.containsKey(grid))
                    grid_hm.put(grid,new HashSet<>());      
                
                if(board[i][j]!='.')
                {
                    int element=board[i][j]-'0';
                    
                
                    if(row_hm.get(row).contains(element) || column_hm.get(column).contains(element) || grid_hm.get(grid).contains(element))
                        return false;
                    
                    row_hm.get(row).add(element);
                    column_hm.get(column).add(element);
                    grid_hm.get(grid).add(element);
                }
            }
        }
        return true;
    }

    private int setGrid(int i,int j)
    {
        int grid=0;
        
        if(i<3)
        {
            if(j<3) grid=0;
            else if(j<6) grid=1;
            else if(j<9) grid=2;
        }
        else if(i<6)
        {
            if(j<3) grid=3;
            else if(j<6) grid=4;
            else if(j<9) grid=5;
        }
        else if(i<9)
        {
            if(j<3) grid=6;
            else if(j<6) grid=7;
            else if(j<9) grid=8;
            
        }
        
        return grid;            
    }
}