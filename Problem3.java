class Solution {
    public boolean isValidSudoku(char[][] board) {

        int m = board.length;
        int n = board[0].length;
        // check all rows
        for (int i = 0; i < m; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (set != null && board[i][j] != '.' && set.contains(board[i][j])) {
                    return false;
                } else if (board[i][j] != '.') {
                    set.add(board[i][j]);
                }
            }
        }

        // check all columns
        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < m; j++) {

                if (set != null && board[j][i] != '.' && set.contains(board[j][i])) {
                    return false;
                } else if (board[j][i] != '.') {
                    set.add(board[j][i]);
                }
            }
        }

        int a = 0;
        while (a <= 6) {
            int b = 0;
            HashSet<Character> set = new HashSet<>();
            while (b <= 6) {
                set = new HashSet<>();
                for (int i = 0 + a; i <= 2 + a; i++) {
                    for (int j = 0 + b; j <= 2 + b; j++) {

                        if (set != null && board[i][j] != '.' && set.contains(board[i][j])) {
                            return false;
                        } else if (board[i][j] != '.') {
                            set.add(board[i][j]);
                        }
                    }
                }

                b += 3;
            }
            a += 3;
        }
        return true;
    }
}
