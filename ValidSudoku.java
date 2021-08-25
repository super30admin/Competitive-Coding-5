//https://leetcode.com/problems/valid-sudoku/

/*
Time: O(m*n) where m=rows and n=columns in the given board
Space: O(m*n) for the Set
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

//Idea : To the Set, (Add each number +  with the R/C indicator + R/C number)

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') // Only the filled cells need to be validated
                    if (!set.add(number + "R" + i) || !set.add(number + "C" + j)
                            || !set.add(number + "B" + i / 3 + j / 3)) // check each of the nine 3 x 3 sub-boxes
                        return false;
            }
        }
        return true;
    }

}
