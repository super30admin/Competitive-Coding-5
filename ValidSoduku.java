/**
Time Complexity : O(M*N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
        int rows = board.length;
        int cols = board[0].length;

        Set<String> set = new HashSet<>();



        for(int i =0; i < rows; i++)
        {
            for(int j =0; j< cols; j++)
            {
                char charVal = board[i][j];

                if(charVal != '.')
                {
                    String rowVal = String.format("ROW_%d_%s", i, Character.toString(charVal));
                    String colVal = String.format("COL_%d_%s", j, Character.toString(charVal));
                    String boxVal = String.format("BOX_%d_%d_%s", i/3,j/3, Character.toString(charVal));

                    boolean isInvalid = set.contains(rowVal) || set.contains(colVal) || set.contains(boxVal);

                    if(isInvalid)
                        return false;

                    set.add(rowVal);
                    set.add(colVal);
                    set.add(boxVal);
                }
            }
        }

        return true;
    }
} 