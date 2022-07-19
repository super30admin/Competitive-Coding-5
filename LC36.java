// Time Complexity : O(m*n)
// Space Complexity : O(m*n)

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    if (!set.contains(board[i][j])) {
                        set.add(board[i][j]);
                    } else {
                        return false;
                    }
                }
            }
        }
        for (int j = 0; j < n; j++) {
            set = new HashSet<>();
            for (int i = 0; i < m; i++) {
                if (board[i][j] != '.') {
                    if (!set.contains(board[i][j])) {
                        set.add(board[i][j]);
                    } else {
                        return false;
                    }
                }
            }
        }

        for (int k = 0; k < 9; k++) {
            set = new HashSet<>();
            for (int i = k / 3 * 3; i < k / 3 * 3 + 3; i++) {
                for (int j = k % 3 * 3; j < k % 3 * 3 + 3; j++) {
                    if (board[i][j] != '.') {
                        if (!set.contains(board[i][j])) {
                            set.add(board[i][j]);
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}