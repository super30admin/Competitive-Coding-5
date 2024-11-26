/*
Run time complexity - O(1) as the maximim number of elements are 9 (size of the sudoku)
Space complexity - O(1) as the maximum number of elements are 9 (size of the sudoku)
*/
public class validate_sudoku {
    public boolean isvalid(char[][] board)
    {
        if(board==null || board.length==0)
            return false;
        int[][] row=new int[9][9];
        int[][] col=new int[9][9];
        int[][] cube =new int[9][9];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]!='.')
                {
                    int val=board[i][j]-'0';
                    val=val-1;
                    int cubeval=(i/3)*3+(j/3);
                    if(row[i][val]==1 || col[j][val]==1 || cube[cubeval][val]==1)
                        return false;
                    else
                    {
                        row[i][val]=1;
                        col[j][val]=1;
                        cube[cubeval][val]=1;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        char[][] board={{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'6','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        validate_sudoku test=new validate_sudoku();
        System.out.println(test.isvalid(board));
    }
}
