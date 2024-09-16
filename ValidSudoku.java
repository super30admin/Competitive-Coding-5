/**Leetcode Question - 36- Valid Sudoku */
/**Algorithm - Run three different loops
 * Loop for checking the roes and columns - Create an array and mark the number encountered as true.
 * If the number is encountered again return false
 * For checking he boxes
 * Rows = box/3*3 to box/3*3+3
 * Columns = box%3*3 to box%3*3+3
 */
/**TC- O(m*n) = O(9*9) = O(1)
 * SC = O(9) - Array creation = O(1)
 */
public class ValidSudoku {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            if(board==null || board.length>9 ||board[0].length >9){
                return false;
            }
            //checking rows
            for(int i =0; i<9;i++){
                boolean[] p = new boolean[9];
                for(int j =0; j<9;j++){
                    if(board[i][j]!='.'){
                        if(p[(int)board[i][j] -'1'] == true){
                            return false;
                        }
                        p[(int)board[i][j] -'1'] = true;
                    }
                }
            }
            
            //checking colums
            for(int j=0; j<9;j++){
                boolean[] p = new boolean[9];
                for(int i=0; i<9;i++){
                    if(board[i][j]!='.'){
                        if(p[(int)board[i][j] -'1'] == true){
                            return false;
                        }
                        p[(int)board[i][j] -'1'] = true;
                    }
                }
            }
            
            //checking box
            for(int box = 0; box<9; box++){
                boolean[] p = new boolean[9];
                for(int i =box/3*3; i<box/3*3+3;i++){
                    for(int j =box%3*3; j<box%3*3+3;j++){
                        if(board[i][j]!='.'){
                            if(p[(int)board[i][j] -'1'] == true){
                                return false;
                            }
                        p[(int)board[i][j] -'1'] = true;
                    }
                }
            } 
        }
            return true;
        }
    }
}
