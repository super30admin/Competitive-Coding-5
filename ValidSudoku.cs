using System;
namespace Algorithms
{
    /// Time Complexity :  O(N2)
    // Space Complexity :O(N) 
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  No
    public class ValidSudoku
    {
        public bool IsValidSudoku(char[][] board)
        {
            if (board == null || board.Length == 0) return false;
            int N = 9;

            int[,] rows = new int[N, N];
            int[,] cols = new int[N, N];
            int[,] boxes = new int[N, N];

            for (int r = 0; r < N; r++)
            {
                for (int c = 0; c < N; c++)
                {
                    if (board[r][c] == '.')
                    {
                        continue;
                    }
                    int pos = board[r][c] - '1';

                    // Check the row
                    if (rows[r, pos] == 1)
                    {
                        return false;
                    }
                    rows[r, pos] = 1;

                    // Check the column
                    if (cols[c, pos] == 1)
                    {
                        return false;
                    }
                    cols[c, pos] = 1;

                    // Check the box
                    int idx = (r / 3) * 3 + c / 3;
                    if (boxes[idx, pos] == 1)
                    {
                        return false;
                    }
                    boxes[idx, pos] = 1;
                }
            }
            return true;



        }
    }
}
