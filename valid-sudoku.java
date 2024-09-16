// Time Complexity : O(N*N)=O(81)
// Space Complexity : O(N)=O(27)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet[] row=new HashSet[9];
        HashSet[] col=new HashSet[9];
        HashSet[] cell=new HashSet[9];
        
        for(int i=0; i<9; i++)
        {
            row[i]=new HashSet<>();
            col[i]=new HashSet<>();
            cell[i]=new HashSet<>();
        }
        
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j] != '.'){
                    if(row[i].contains(board[i][j]) || col[j].contains(board[i][j]) || cell[3*(i/3)+j/3].contains(board[i][j]))
                    {
                        return false;
                    }
                else{
                    row[i].add(board[i][j]);
                    col[j].add(board[i][j]);
                    cell[3*(i/3)+j/3].add(board[i][j]);
                }
                }
            }
        }
        return true;
    }
}