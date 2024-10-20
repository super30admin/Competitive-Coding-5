class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean flag=true;

        for(int i=0;i<9;i++){
            flag=flag && checkrow(board,i) && checkcolumn(board,i);
        }

        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                flag = flag && checksq(board,i,j);
            }
        }
        return flag;
    }
    private boolean checkrow(char[][] board, int i){

        HashSet<Character> set = new HashSet<>();
        for(int j=0;j<9;j++){
            if(set.contains(board[i][j]) && board[i][j]!='.'){
                return false;
            }
            else set.add(board[i][j]);
        }
        return true;
    }
    private boolean checkcolumn(char[][] board, int j){

        HashSet<Character> set = new HashSet<>();

        for(int i=0;i<9;i++){
            if(set.contains(board[i][j]) && board[i][j]!='.'){
                return false;
            }
            else set.add(board[i][j]);
        }
        return true;
    }

    private boolean checksq(char [][] board, int i, int j){
        HashSet<Character> set = new HashSet<>();

        for(int k=i;k<i+3;k++){
            for(int l=j;l<j+3;l++){
                if(set.contains(board[k][l]) && board[k][l]!='.'){
                return false;
            }
            else set.add(board[k][l]);
            }
        }
        return true;
    }
}
