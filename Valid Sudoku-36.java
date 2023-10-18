class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isRow(board, i) || !isCol(board, i) || !isSub(board, i)) {
                return false;
            }
        }
        return true;        
    }

    private boolean isRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char digit = board[row][i];
            if (digit != '.') {
                if (set.contains(digit)) {
                    return false;
                }
                set.add(digit);
            }
        }
        return true;
    }

    private boolean isCol(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char digit = board[i][col];
            if (digit != '.') {
                if (set.contains(digit)) {
                    return false;
                }
                set.add(digit);
            }
        }
        return true;
    }

    private boolean isSub(char[][] board, int subgrid) {
        Set<Character> set = new HashSet<>();
        int rowStart = (subgrid / 3) * 3;
        int colStart = (subgrid % 3) * 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                char digit = board[i][j];
                if (digit != '.') {
                    if (set.contains(digit)) {
                        return false;
                    }
                    set.add(digit);
                }
            }
        }
        return true;
    }


}
