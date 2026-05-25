// Time Complexity : O(1) - 9*9 grid hence costant time
// Space Complexity : O(1) - 3 sets are created at any time with max size = 9
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
    I traverse through each element of the board and create the rowSet and columnSet for that position if the element is not = '.' . If the sets don't already have my current element, I add it to the
    respective row and column set. If not I return false. After this, I go through the 9 3*3 boxes in the board and create a boxSet for each and repeat the same process as the row and col set.
*/

public class Solution
{
    public bool IsValidSudoku(char[][] board)
    {
        for (int i = 0; i < 9; i++)
        {
            HashSet<char> rowSet = new();
            HashSet<char> colSet = new();
            for (int j = 0; j < 9; j++)
            {
                char rowCh = board[i][j];
                char colCh = board[j][i];

                if (rowCh != '.')
                {
                    if (rowSet.Contains(rowCh))
                    {
                        return false;
                    }

                    rowSet.Add(rowCh);
                }

                if (colCh != '.')
                {
                    if (colSet.Contains(colCh))
                    {
                        return false;
                    }

                    colSet.Add(colCh);
                }
            }
        }

        return CheckBoxes(board);
    }

    public bool CheckBoxes(char[][] board)
    {
        for (int nr = 0; nr < 9; nr += 3)
        {
            for (int nc = 0; nc < 9; nc += 3)
            {
                HashSet<char> boxSet = new();

                for (int i = nr; i < nr + 3; i++)
                {
                    for (int j = nc; j < nc + 3; j++)
                    {
                        char boxCh = board[i][j];

                        if (boxCh != '.')
                        {
                            if (boxSet.Contains(boxCh))
                            {
                                return false;
                            }

                            boxSet.Add(boxCh);
                        }
                    }
                }
            }
        }

        return true;
    }
}