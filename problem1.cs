public class Solution {
    public bool IsValidSudoku(char[][] board) {
        int m = board.Length;
        int n= board[0].Length;
        HashSet<char>[] rset = new HashSet<char>[9];
HashSet<char>[] cset = new HashSet<char>[9];
HashSet<char>[] mset = new HashSet<char>[9];

        for(var i=0;i<9;i++)
        {
            rset[i]= new HashSet<char>();
            cset[i]= new HashSet<char>();
            mset[i]= new HashSet<char>();
        }
        for(var i=0;i<m;i++)
        {
            for(var j=0;j<n;j++)
            {
                if(board[i][j] != '.')
                {
                    if(!rset[i].Contains(board[i][j]))
                        rset[i].Add(board[i][j]);
                    else
                        return false;
                }
                if(board[j][i] != '.')
                {
                    if(!cset[i].Contains(board[j][i]))
                        cset[i].Add(board[j][i]);
                    else
                        return false;
                }
                var boxId = i/3+(j/3*3);
                if(board[i][j] != '.')
                {
                    if(!mset[boxId].Contains(board[i][j]))
                        mset[boxId].Add(board[i][j]);
                    else
                        return false;
                }
            }
        }
        return true;
    }
}