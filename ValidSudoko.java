// Time Complexity: O(n^2) where n = 8
// Space Complexity: O(n^2)
public class ValidSudoko {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return false;
        
        Set<String> checkVal = new HashSet<>();

        for(int i = 0 ; i < board.length; i++)
        {
            for(int j = 0 ; j < board[0].length; j++)
            {
                char curr = board[i][j];
                if(!Character.isDigit(curr))
                    continue;
                String rowVal = "r"+i+curr;
                String colVal = "c"+j+curr;
                String boxVal = "r"+(i/3)+"c"+(j/3)+curr;

                if(checkVal.contains(rowVal) || checkVal.contains(colVal) || checkVal.contains(boxVal))
                {
                   return false;
                }
                else
                {
                    checkVal.add(rowVal);
                    checkVal.add(colVal);
                    checkVal.add(boxVal);
                }
            }
        }
        return true;
    }
}
