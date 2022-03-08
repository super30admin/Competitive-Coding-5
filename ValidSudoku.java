// TC: O(n^2)
// SC: O(n^2)

// Approach: Create a HashSet for each row, each column and each
// 3x3 box. We add the values in the HashSet and check if we have
// seen it before.

// LC- 36 Valid Sudoku

import java.util.*;

public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    if (board == null) {
      return false;
    }

    HashSet<Character>[] rows = new HashSet[9];
    HashSet<Character>[] cols = new HashSet[9];
    HashSet<Character>[] boxes = new HashSet[9];

    for (int i = 0; i < 9; i++) {
      rows[i] = new HashSet<Character>();
      cols[i] = new HashSet<Character>();
      boxes[i] = new HashSet<Character>();
    }

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char val = board[i][j];

        if (val == '.') {
          continue;
        }

        if (rows[i].contains(val)) {
          return false;
        }
        rows[i].add(val);

        if (cols[j].contains(val)) {
          return false;
        }
        cols[j].add(val);

        int index = (i / 3) * 3 + j / 3;
        if (boxes[index].contains(val)) {
          return false;
        }
        boxes[index].add(val);
      }
    }

    return true;
  }
}
