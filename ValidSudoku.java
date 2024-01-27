public class ValidSudoku {
    // TC: O(N * N) where N is length of board
    // SC: O(N * N) where N is length of board
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (row.contains(board[i][j])) {
                    return false;
                } else if (board[i][j] != '.') {
                    row.add(board[i][j]);
                }
                if (col.contains(board[j][i])) {
                    return false;
                } else if (board[j][i] != '.') {
                    col.add(board[j][i]);
                }
            }
        }

        int startRow = 0, startCol = 0;
        while (startRow < n) {
            int endRow = startRow + 3;
            int endCol = startCol + 3;
            Set<Character> box = new HashSet<>();
            for (int i = startRow; i < endRow; i++) {
                for (int j = startCol; j < endCol; j++) {
                    if (box.contains(board[i][j])) {
                        return false;
                    } else if (board[i][j] != '.') {
                        box.add(board[i][j]);
                    }
                }
            }
            startCol += 3;
            if (startCol == n) {
                startCol = 0;
                startRow += 3;
            }
        }
        return true;
    }
}
