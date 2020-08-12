//Time complexity:O(1) => going through 9x9 array
//Space complexity:O(1)
/*Approach 
-checking all rows first and if any row has duplicates it will return false, for every row taking a boolean
if anything is found it will place a true in its place to keep track of what all numbers we have found
-similarily going for columns and then thorugh 3x3 blocks to check for duplicates
*/
public class Sudoku {
        public boolean isValidSudoku(char[][] board) {
           if(board == null || board.length != 9 || board[0].length != 9)return false;
            //for each row
            for(int i = 0;i < 9;i++){
                boolean[] row = new boolean[9];
                for(int j= 0; j <9;j++){
                    if(board[i][j] != '.'){
                        if(row[(int)(board[i][j]-'1')] == true)return false;
                        row[(int)(board[i][j]-'1')] = true;
                    }
                    
                }
            }
            
            //for each col
            for(int j = 0;j < 9;j++){
                boolean[] col = new boolean[9];
                for(int i= 0; i <9;i++){
                    if(board[i][j] != '.'){
                        if(col[(int)(board[i][j]-'1')] == true)return false;
                        col[(int)(board[i][j]-'1')] = true;
                    }
                    
                }
            }
            
            //for 3x3 sq
            for(int i = 0;i < 9;i++){
                boolean[] sq = new boolean[9];
                for(int j = i/3 *3;j<i/3*3+3;j++){
                    for(int k= i%3*3; k < i%3*3+3;k++){
                    if(board[j][k] != '.'){
                        if(sq[(int)(board[j][k]-'1')] == true)return false;
                        sq[(int)(board[j][k]-'1')] = true;
                    }
    
                    }
                }
            }
            return true;
        }
        public static void main(String args[]) {
            Sudoku obj = new Sudoku();
            System.out.println(obj.isValidSudoku(new char[][]
                { { '5', '3', '.', '.', '7', '.', '.', '.', '.' }, 
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, 
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' }, 
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' }, 
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }

              ));
        }
}