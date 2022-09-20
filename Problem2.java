public class Problem2 {
    public boolean isValidSudoku(char[][] board) {

        for(int i=0;i<9;i++){
            boolean[] b = new boolean[9];
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(b[(int)board[i][j]-'1']) return false;
                    b[(int)board[i][j]-'1'] = true;
                }
            }
        }

        for(int j=0;j<9;j++){
            boolean[] b = new boolean[9];
            for(int i=0;i<9;i++){
                if(board[i][j]!='.'){
                    if(b[(int)board[i][j]-'1']) return false;
                    b[(int)board[i][j]-'1'] = true;
                }
            }
        }

        for(int block = 0; block< 9; block ++){
            for(int i = block/3*3; i< block/3*3+3; i++){
                for(int j=block%3*3; j< block%3*3+3; j++){
                    if(board[i][j]!='.'){
                        if(b[(int)(board[i][j]-'1')]) return false;
                        b[(int)(board[i][j]-'1')] = true;
                    }
                }
            }
        }
        return true;
    }
}