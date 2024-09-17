O(n^2) time and O(1) space

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int current;
        for(int i=0;i<board.length;i++){
            current = 0;
            for(int j=0;j<board.length;j++){
                if(board[i][j] == '.')
                    continue;
                if(current == (current | 1<<(board[i][j]-'0')))
                    return false;
                current = (current |  1<<(board[i][j]-'0'));
            }

            current = 0;
            for(int j=0;j<board.length;j++){
                if(board[j][i] == '.')
                    continue;
                if(current == (current | 1<<(board[j][i]-'0')))
                    return false;
                current = (current |  1<<(board[j][i]-'0'));
            }

        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                current = 0;
                for(int a=i;a<i+3;a++){
                    for(int b=j;b<j+3;b++){
                        if(board[a][b] == '.')
                            continue;
                        if(current == (current | 1<<(board[a][b]-'0')))
                            return false;
                        current = (current |  1<<(board[a][b]-'0'));
                    }
                }
            }
        }
        return true;
    }
}