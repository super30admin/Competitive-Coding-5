package CompetitiveCoding5;

public class question70_ValidSudoku {
    /* Created by palak on 6/30/2021 */

    /*
        Time Complexity: O()
        Space Complexity: O()
    */
    public static boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9) return false;

        //Checking the Row
        for(int i = 0 ; i < 9 ; i++) {
            boolean visited[] = new boolean[9];
            for(int j = 0; j < 9 ; j++) {
                if(board[i][j] != '.') {
                    if(visited[(int)(board[i][j] - '1')]) return false;
                    visited[(int)(board[i][j] - '1')] = true;
                }
            }
        }

        //Checking the Col
        for(int j = 0 ; j < 9 ; j++) {
            boolean visited[] = new boolean[9];
            for(int i = 0; i < 9 ; i++) {
                if(board[i][j] != '.') {
                    if(visited[(int)(board[i][j] - '1')]) return false;
                    visited[(int)(board[i][j] - '1')] = true;
                }
            }
        }

        //Block
        for(int block = 0 ; block < 9 ; block++) {
            boolean[] visited = new boolean[9];
            for(int i = block / 3 * 3 ; i < block / 3 * 3 + 3 ; i++) {
                for(int j = block % 3 * 3 ; j < block % 3 * 3 + 3 ; j++) {
                    if(board[i][j] != '.') {
                        if(visited[(int)(board[i][j] - '1')]) return false;
                        visited[(int)(board[i][j] - '1')] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {{'5','3','.','.','7','.','.','.','.'} ,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};

        isValidSudoku(board);
    }
}