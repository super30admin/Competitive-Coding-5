class ValidSudoku {
    int m, n;
    public boolean isValidSudoku(char[][] board) {

        this.m = board.length;
        this.n = board[0].length;

        boolean rowFlag = checkRow(board);

        if(!rowFlag) return false;

        boolean colFlag = checkCol(board);

        if(!colFlag) return false;

        boolean flag = checkCells(board);

        if(!flag) return false;

        return true;
    }

    private boolean checkRow(char[][] board) {

        for(int i=0; i<m; i++) {

            HashSet<Character> set = new HashSet<>();

            for(int j=0; j<n; j++) {
                char c = board[i][j];
                if(c != '.') {
                    if(set.contains(c))
                        return false;
                    else
                        set.add(c);
                }
            }
        }

        return true;
    }

    private boolean checkCol(char[][] board) {

        for(int i=0; i<m; i++) {

            HashSet<Character> set = new HashSet<>();

            for(int j=0; j<n; j++) {
                char c = board[j][i];
                if(c != '.') {
                    if(set.contains(c))
                        return false;
                    else
                        set.add(c);
                }
            }
        }

        return true;
    }

    private boolean checkCells(char[][] board) {

        int rowLen = 0;
        int colLen = 0;

        for(int a=0; a<9; a+=3) {
            for(int b=0; b<9; b+=3) {
                HashSet<Character> set = new HashSet<>();
                for(int i=a; i<a+3; i++) {
                    for(int j=b; j<b+3; j++) {
                        char c = board[i][j];
                        if(c != '.') {
                            if(set.contains(c))
                                return false;
                            else
                                set.add(c);
                        }
                    }
                }
            }

        }

        return true;
    }
}
