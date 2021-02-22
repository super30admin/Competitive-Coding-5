package MockInterviews.CompetitiveCoding5;


/**
 * Successfully ran on leetcode
 * Time compesity: O(n*n)
 * Space Complexity: O(1)
 * Approach: iterate over array 3 times to check rows, columns, blocks
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            boolean bool[] = new boolean[9];
            for(int j=0; j<9; j++){
                if(board[i][j] == '.')
                    continue;
                if(bool[Character.getNumericValue(board[i][j])-1])
                    return false;
                else
                    bool[Character.getNumericValue(board[i][j])-1] = true;
            }
        }

        for(int j=0; j<9; j++){
            boolean bool[] = new boolean[9];
            for(int i=0; i<9; i++){
                if(board[i][j] == '.')
                    continue;
                if(bool[Character.getNumericValue(board[i][j])-1])
                    return false;
                else
                    bool[Character.getNumericValue(board[i][j])-1] = true;
            }
        }

        for(int block =0 ; block <9; block++){
            boolean bool[] = new boolean[9];
            for(int i=block/3*3 ; i< block/3*3+3; i++){
                for(int j=block%3*3 ; j< block%3*3+3; j++){
                    if(board[i][j] == '.')
                        continue;
                    if(bool[Character.getNumericValue(board[i][j])-1])
                        return false;
                    else
                        bool[Character.getNumericValue(board[i][j])-1] = true;
                }
            }
        }
        return true;
    }
}
