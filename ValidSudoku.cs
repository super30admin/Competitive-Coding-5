
// Time Complexity - O(1)
// Space Complexity - O(1)

// Approach
// Maintain hashset to ensure values are not repeated in rows columns or in the box.
//for BFS use Queue, iterated over matrix and enqueued all the cells.
//generated keys ensuring duplicates are not inserted in the hashset else return false;

public class Solution
{
    //BFS Solution using Queue
    public bool IsValidSudoku(char[][] board)
    {
        HashSet<string> seen = new HashSet<string>();
        Queue<int[]> q = new Queue<int[]>();

        for (int r = 0; r < 9; r++)
        {
            for (int c = 0; c < 9; c++)
            {
                q.Enqueue(new int[] { r, c });
            }
        }

        while (q.Count > 0)
        {
            int[] cell = q.Dequeue();
            int r = cell[0];
            int c = cell[1];

            char val = board[r][c];
            if (val == '.') continue;

            string rowKey = val + " in row " + r;
            string colKey = val + " in col " + c;
            string boxKey = val + " in box " + (r / 3) + "-" + (c / 3);

            if (!seen.Add(rowKey) ||
                !seen.Add(colKey) ||
                !seen.Add(boxKey))
            {
                return false;
            }
        }

        return true;
    }
}


//DFS
public class Solution {
    HashSet<string> seen = new HashSet<string>();

    public bool IsValidSudoku(char[][] board) {
        return DFS(board, 0, 0);
    }

    public bool DFS(char[][] board, int r, int c)
    {
        if (r == 9) return true;//finished all rows
        if (c == 9)
        {
            return DFS(board, r + 1, 0); // Must return here! next row
        }

        char val = board[r][c];
        if (val != '.')
        {
            string row = val + " in row " + r;
            string col = val + " in col " + c;
            string box = val + " in box " + r/3 + "-" + c/3;

            if (!seen.Add(row) || !seen.Add(col) || !seen.Add(box))
                return false;
        }

        return DFS(board, r, c + 1);
    }
}


