public class Problem1 {
    //t.c->O(m*n)
    //sc -> O(1)
    public boolean isValidSudoku(char[][] board) {
    //base case
    if(board == null || board.length != 9 || board[0].length != 9){
        return false;
    }
    //for row
    for(int i = 0;i<9;i++){
        boolean[] visitedArray = new boolean[9];
        for(int j = 0;j<9;j++){
            if(board[i][j]!='.'){
                if(visitedArray[(int)(board[i][j]-'1')]) return false;
                visitedArray[(int)(board[i][j]-'1')] = true;
            }
        }
    }
    //for col
    for(int j = 0;j<9;j++){
        boolean[] visitedArray = new boolean[9];
        for(int i = 0;i<9;i++){
            if(board[i][j]!='.'){
                if(visitedArray[(int)(board[i][j]-'1')]) return false;
                visitedArray[(int)(board[i][j]-'1')] = true;
            }
        }
    }
    //for matrix of size 3 * 3
    for(int matrix = 0;matrix<9;matrix++){
        boolean[] visitedArray = new boolean[9];
        for(int i = matrix/3*3;i<matrix/3*3+3;i++){
            for(int j = matrix%3*3;j<matrix%3*3+3;j++){
                if(board[i][j]!='.'){
                    if(visitedArray[(int)(board[i][j]-'1')]) return false;
                    visitedArray[(int)(board[i][j]-'1')] = true;
                }
            }
        }
    }
    return true;
}
}