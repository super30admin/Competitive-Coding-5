// Time Complexity : O(N^2)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }
        int N = 9;
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] blocks = new HashSet[N];
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<>();
            cols[r] = new HashSet<>();
            blocks[r] = new HashSet<>();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char value = board[i][j];
                if (value == '.') {
                    continue;
                }
                int blockIdx = (i / 3) * 3 + (j / 3);
                if (rows[i].contains(value) || cols[j].contains(value) || blocks[blockIdx].contains(value)) {
                    return false;
                }
                rows[i].add(value);
                cols[j].add(value);
                blocks[blockIdx].add(value);
            }
        }
        return true;
    }
}