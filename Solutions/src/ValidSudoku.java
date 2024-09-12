
class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //base
        if(board==null || board[0].length==0 || board.length==0 || board.length != 9 || board[0].length!=9 ) return false;

        // row check
        for(int i=0;i<board.length;i++){
            boolean[] row = new boolean[9];
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    if(row[(int)(board[i][j]-'1')]==true) return false;
                    row[(int)(board[i][j]-'1')]=true;
                }
            }
        }
        // column check
        for(int i=0;i<board.length;i++){
            boolean[] col = new boolean[9];
            for(int j = 0;j<board[0].length;j++){
                if(board[j][i]!='.'){
                    if(col[(int)(board[j][i]-'1')]==true) return false;
                    col[(int)(board[j][i]-'1')]=true;
                }
            }
        }

        //check box

        for(int block = 0;block<9;block++){
            boolean[] blocks = new boolean[9];
            for(int row = block/3*3;row<block/3*3+3;row++){
                for(int col = block%3*3;col<block%3*3+3;col++){
                    if(board[row][col]!='.'){
                        if(blocks[(int)(board[row][col]-'1')]==true) return false;
                        blocks[(int)(board[row][col]-'1')]=true;
                    }
                }
            }
        }

        return true;
    }

}