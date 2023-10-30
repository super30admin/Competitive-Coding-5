public class ValidSudoku
    {
        // Time Complexity : O( 3(m * n) ) ~ O(m * n)
        // Space Complexity : O(m) or O(n)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        public bool IsValidSudoku(char[][] board)
        {
            int m = board.Length;
            int n = board[0].Length;
            for (int i = 0; i < m; i++)
            {
                HashSet<char> rowset = new HashSet<char>();
                for (int j = 0; j < n; j++)
                {
                    if (board[i][j] != '.')
                    {
                        if (rowset.Contains(board[i][j]))
                        {
                            return false;
                        }
                        rowset.Add(board[i][j]);
                    }
                }
            }

            //check column
            for (int j = 0; j < n; j++)
            {
                HashSet<int> colset = new HashSet<int>();
                for (int i = 0; i < m; i++)
                {
                    if (board[i][j] != '.')
                    {
                        if (colset.Contains(board[i][j]))
                        {
                            return false;

                        }
                        colset.Add(board[i][j]);
                    }
                }
            }


            //check 3 * 3 box
            for (int i = 0; i < m; i += 3)
            {
                for (int j = 0; j < n; j += 3)
                {
                    HashSet<int> boxset = new HashSet<int>();

                    for (int x = 0; x < 3; x++)
                    {
                        for (int y = 0; y < 3; y++)
                        {
                            if (board[i + x][j + y] != '.')
                            {
                                if (boxset.Contains(board[i + x][j + y]))
                                {
                                    return false;
                                }
                                boxset.Add(board[i + x][j + y]);
                            }
                        }
                    }

                }
            }
            return true;
        }
    }
