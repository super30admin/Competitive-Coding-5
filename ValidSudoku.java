/*
Time Complexity : O(rows*cols) rows and cols of the sudoku
Space Complexity : O(1) -  9+9+9 hashsets - So constant space
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Approach :
We need to maintain 9 hashsets, one for each row, 9 hashsets, one for each column and 9 hashsets one for each 3x3 box.
Each time we explore a cell on the board we check the hashset corresponding to its row(i), has that value or not. If it
contains the value already return true. Check if the value is present in the column hashset(j) and box hashset(box index),
if yes, return true as it is invalid sudoku.
*/
import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        // maintain hashset for rows, column and the boxes
        HashSet<Character>[] rowHashSets = new HashSet[rows];
        HashSet<Character>[] colHashSets = new HashSet[cols];
        HashSet<Character>[] boxHashSets = new HashSet[rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.') continue;
                char currentChar = board[i][j];
                // box index is derived from row and column of the cell
                int boxIndex = 3*(i/3) + (j/3);

                createSets(colHashSets, rowHashSets, boxHashSets, i, j, boxIndex);
                // check if value is present already in row, column or box hashset
                if (isExits(currentChar, rowHashSets, i)) return false;
                if (isExits(currentChar, colHashSets, j)) return false;
                if (isExits(currentChar, boxHashSets, boxIndex)) return false;
            }
        }
        return true;
    }

    private static boolean isExits(char currentChar, HashSet<Character>[] set, int index) {
        if (set[index].contains(currentChar)) {
            return true;
        }
        set[index].add(currentChar);
        return false;
    }

    private void createSets(HashSet<Character>[] colHashSets, HashSet<Character>[] rowHashSets,
                            HashSet<Character>[] boxHashSets, int i, int j, int boxIndex) {
        if (colHashSets[j] == null) {
            colHashSets[j] = new HashSet<>();
        }
        if (rowHashSets[i] == null) {
            rowHashSets[i] = new HashSet<>();
        }
        if (boxHashSets[boxIndex] == null) {
            boxHashSets[boxIndex] = new HashSet<>();
        }
    }
}
