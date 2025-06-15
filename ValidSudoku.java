// TC: O(1)
// SC: O(1)
// Approach:
// We keep a HashSet of strings that represent what we've seen so far.
// For each non - (non-empty) cell, we store:
// rowIndex(value) → to detect row duplicates
// (value)colIndex → to detect column duplicates
// boxRow(value)boxCol" → to detect 3x3 box duplicates
// If any of these strings are already in the HashSet, then it's a duplicate and not valid.

public class ValidSudoku {

  public static boolean isValidSudoku(char[][] board) {
    java.util.HashSet<String> seen = new java.util.HashSet<>();

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char element = board[i][j];
        if (element != '.') {
          String rowKey = i + "(" + element + ")";
          String colKey = "(" + element + ")" + j;
          String boxKey = (i / 3) + "(" + element + ")" + (j / 3);

          if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    char[][] board = {
        { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
        { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
        { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
        { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
        { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
        { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
        { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
        { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
        { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
    };

    boolean result = isValidSudoku(board);
    System.out.println(result);
  }
}
