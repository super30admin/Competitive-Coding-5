import java.util.HashSet;
//tc = o(m*n)
//sc = o(m*n)
class Solution {
    private boolean helper(int r,int c,char[][] board){
            HashSet<Character> set = new HashSet<>();
            for(int i=r;i<r+3;i++){
                for(int j=c;j<c+3;j++){
                    if(board[i][j] != '.'){
                        if(set.contains(board[i][j])){
                            return false;
                        }
                        else{
                            set.add(board[i][j]);
                        }
                    }
                }
            }
            return true;
    }
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            HashSet<Character> rowSet = new HashSet<>();
            for(int j = 0;j<n;j++){
                if(board[i][j] != '.'){
                    if(rowSet.contains(board[i][j])){
                        return false;
                    }
                    else{
                        rowSet.add(board[i][j]);
                    }
                }
            }
           
        }

        for(int i=0;i<m;i++){
            HashSet<Character> colSet = new HashSet<>();
            for(int j=0;j<n;j++){
                if(board[j][i] != '.'){
                    if(colSet.contains(board[j][i])){
                        return false;
                    }
                    else{
                        colSet.add(board[j][i]);
                    }

                }
            }
        }

        for(int i=0;i<m;i=i+3){
            for(int j=0;j<n;j=j+3){
                if(helper(i,j,board) == false){
                    return false;
                }
            }
        }

        


        return true;


    }
}