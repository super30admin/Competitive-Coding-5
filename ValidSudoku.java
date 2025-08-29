class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Validate rows
        Set<Character> set = new HashSet();
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[i][j]=='.') continue;
                if(set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
            set = new HashSet();
        }

        // Validate cols
        set = new HashSet();
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(board[j][i]=='.') continue;
                if(set.contains(board[j][i])) {
                    return false;
                }
                set.add(board[j][i]);
            }
            set = new HashSet();
        }

        // Validate blocks
        set = new HashSet();
        for(int s=0;s<9;s++) {
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    // get row index for block
                    int row = i+((s/3)*3);
                    // get col index for block
                    int col = j+((s%3)*3);
                    if(board[row][col]=='.') continue;
                    if(set.contains(board[row][col])) {
                        return false;
                    }
                    set.add(board[row][col]);
                }
            }
            set = new HashSet();
        }

        return true;
    }
}
