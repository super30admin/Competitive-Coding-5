// Time Complexity : O(n*n)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows=board.length;
        int columns = board[0].length;
        
        for(int i=0;i<rows;i++)
        {
            HashSet<Character> rowSet = new HashSet<>();
            for(int j=0;j<columns;j++)
            {
                if(board[i][j]!='.')
                {
                    if(rowSet.contains(board[i][j]))
                    {
                        return false;
                    }
                    rowSet.add(board[i][j]);
                }
            }
        }

        for(int i=0;i<rows;i++)
        {
            HashSet<Character> columnSet = new HashSet<>();
            for(int j=0;j<columns;j++)
            {
                if(board[j][i]!='.')
                {
                    if(columnSet.contains(board[j][i]))
                    {
                        return false;
                    }
                    columnSet.add(board[j][i]);
                }
            }
        }

        for(int i=0;i<rows;i+=3)
        {
            for(int j=0;j<columns;j+=3)
            {
                if(!check(board,i,j))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean check(char [][]board,int x,int y)
    {
        HashSet<Character> box = new HashSet<>();
        for(int i=x;i<x+3;i++)
        {
            for(int j=y;j<y+3;j++)
            {
                if(board[i][j]!='.')
                {
                    if(box.contains(board[i][j]))
                    {
                        return false;
                    }
                    box.add(board[i][j]);
                }
            }
        }
        return true;
    }
}