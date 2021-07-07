class ValidSudoku{
    public boolean isValidSudoku(char[][] board) {
        if(board == null) return false;
        for(int i=0; i<9; i++){
            boolean[] visited = new boolean[9];
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'){
                    if(visited[board[i][j] - '1']) return false;
                    visited[board[i][j] - '1'] = true;
                }
            }
        }

        for(int j=0; j<9; j++){
            boolean[] visited = new boolean[9];
            for(int i=0; i<9; i++){
                if(board[i][j]!='.'){
                    if(visited[board[i][j] - '1']) return false;
                    visited[board[i][j] - '1'] = true;
                }
            }
        }

        for(int block=0; block<9; block++){
            boolean[] visited = new boolean[9];
            for(int i = block/3*3; i<block/3*3+3; i++){
                for(int j=block%3*3; j<block%3*3+3; j++){
                    if(board[i][j]!='.'){
                        if(visited[board[i][j] - '1']) return false;
                        visited[board[i][j] - '1'] = true;
                    }
                }
            }
        }

        return true;
    }
}