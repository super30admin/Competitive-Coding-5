/*
  Time complexity: O(m*n)
  Space complexity: O(m*n)

  Code ran successfully on Leetcode: Yes
  
*/

public class Solution {
    public bool IsValidSudoku(char[][] board) {
        HashSet<char>[] hsRow = new HashSet<char>[9];
        HashSet<char>[] hsColumn = new HashSet<char>[9];
        HashSet<char>[][] hsBoxes = new HashSet<char>[3][];
        
        for(int m=0;m<9;m++)
        {
            hsRow[m]=new HashSet<char>();
            hsColumn[m]=new HashSet<char>();
        }
        
        for(int k=0;k<3;k++)
        {
            hsBoxes[k] = new HashSet<char>[3];
        }
        
        for(int m=0;m<3;m++)
        {
            for(int n=0;n<3;n++)
            {
                hsBoxes[m][n]=new HashSet<char>();
            }
        }
        
        for(int i=0;i<board.Length;i++)
        {
            for(int j=0;j<board[i].Length;j++)
            {
                
                
                if(board[i][j]=='.')
                    continue;
                
                
                
                if(hsRow[i].Contains(board[i][j]))
                    return false;
                else
                    hsRow[i].Add(board[i][j]);
                
                if(hsColumn[j].Contains(board[i][j]))
                    return false;
                else
                    hsColumn[j].Add(board[i][j]);
                
                
                int row = i/3;
                int column = j/3;
                
                if(hsBoxes[row][column].Contains(board[i][j]))
                    return false;
                else
                    hsBoxes[row][column].Add(board[i][j]);
                
                
            }
        }
        
        return true;
    }
}
