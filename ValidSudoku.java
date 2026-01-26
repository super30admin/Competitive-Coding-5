import java.util.HashSet;

/*
Problem: Valid Sudoku (LeetCode 36)
Approach:
- Use 3 arrays of HashSet<Character>:
  rows[i]  tracks digits seen in row i
  cols[j]  tracks digits seen in column j
  boxes[k] tracks digits seen in 3x3 box k
- While scanning each cell, if digit already exists in any corresponding set -> invalid.

Time Complexity:
O(1) because board size is fixed 9x9.
(For a generalized N x N Sudoku, it would be O(N^2).)

Space Complexity:
O(1) for fixed 9x9 board.
(Generalized: O(N^2) total storage across sets.)
*/

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // Initialize sets for each row, column, and 3x3 box
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Scan every cell once
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                char c = board[i][j];
                if (c == '.') continue; // skip empty

                // Check row
                if (rows[i].contains(c)) return false;
                rows[i].add(c);

                // Check column
                if (cols[j].contains(c)) return false;
                cols[j].add(c);

                // Check 3x3 box
                int boxIdx = (i / 3) * 3 + (j / 3); // maps (i,j) -> [0..8]
                if (boxes[boxIdx].contains(c)) return false;
                boxes[boxIdx].add(c);
            }
        }

        return true;
    }
    public static void main(String[] args) {
            ValidSudoku sol = new ValidSudoku();

            // Valid board (classic LeetCode example)
            char[][] validBoard = {
                    {'5','3','.','.','7','.','.','.','.'},
                    {'6','.','.','1','9','5','.','.','.'},
                    {'.','9','8','.','.','.','.','6','.'},
                    {'8','.','.','.','6','.','.','.','3'},
                    {'4','.','.','8','.','3','.','.','1'},
                    {'7','.','.','.','2','.','.','.','6'},
                    {'.','6','.','.','.','.','2','8','.'},
                    {'.','.','.','4','1','9','.','.','5'},
                    {'.','.','.','.','8','.','.','7','9'}
            };

            // Invalid board: duplicate '5' in first row (two 5s)
            char[][] invalidBoardRowDup = {
                    {'5','3','.','.','7','.','.','.','5'},
                    {'6','.','.','1','9','5','.','.','.'},
                    {'.','9','8','.','.','.','.','6','.'},
                    {'8','.','.','.','6','.','.','.','3'},
                    {'4','.','.','8','.','3','.','.','1'},
                    {'7','.','.','.','2','.','.','.','6'},
                    {'.','6','.','.','.','.','2','8','.'},
                    {'.','.','.','4','1','9','.','.','5'},
                    {'.','.','.','.','8','.','.','7','9'}
            };

            boolean res1 = sol.isValidSudoku(validBoard);
            System.out.println("Test 1 (valid board) -> " + res1 + " | expected: true");

            boolean res2 = sol.isValidSudoku(invalidBoardRowDup);
            System.out.println("Test 2 (row duplicate) -> " + res2 + " | expected: false");
    }
}
