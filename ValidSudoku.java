// Time Complexity : O(1)
// Space Complexity : O(1)
import java.util.*;
public class ValidSudoku {
    static boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        HashSet<Character>[] rowSet = new HashSet[9];
        HashSet<Character>[] colSet = new HashSet[9];
        HashSet<Character>[] boxSet = new HashSet[9];
        for(int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] != '.') {
                    if(!rowSet[i].contains(board[i][j]))
                        rowSet[i].add(board[i][j]);
                    else
                        return false;
                }
                if(board[j][i] != '.' ) {
                    if(!colSet[i].contains(board[j][i]))
                        colSet[i].add(board[j][i]);
                    else
                        return false;
                }
                int boxIdx = (i / 3 + j / 3 * 3);
                if(board[i][j] != '.') {
                    if(!boxSet[boxIdx].contains(board[i][j]))
                        boxSet[boxIdx].add(board[i][j]);
                    else
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
