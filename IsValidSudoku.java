import java.util.HashMap;
import java.util.Map;

public class IsValidSudoku {
//Time complexity is O(N^2)
//Space complexity is 0(1)
        public boolean isValidSudoku(char[][] board) {
            for(int i =0; i<9; i++){
                for(int j=0; j<9; j++){
                    if(board[i][j] != '.' && !isValid(board, i, j)){
                        return false;
                    }
                }
            }
            return true;
        }

        public boolean isValid(char[][] board, int r, int c){
            char cr = board[r][c];

            //check row
            for(int i=c+1; i<9; i++){
                if(board[r][i]==cr) return false;
            }

            //check col
            for(int i=r+1; i<9; i++){
                if(board[i][c]==cr) return false;
            }

            //check for 9x9
            board[r][c] = '.';
            int row = r/3*3;
            int col = c/3*3;

            for(int i =row; i<row+3; i++){
                for (int j =col; j<col+3; j++){
                    if(board[i][j]==cr) return false;
                }
            }
            board[r][c] = cr;
            return true;
        }
}
