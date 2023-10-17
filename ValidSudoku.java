// TC will be O(1)
//SC will be O(1)

import java.util.HashSet;
import java.util.Set;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i) || !isValidColumn(board, i) || !isValidSubgrid(board, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char digit = board[row][i];
            if (digit != '.') {
                if (set.contains(digit)) {
                    return false;
                }
                set.add(digit);
            }
        }
        return true;
    }

    private boolean isValidColumn(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char digit = board[i][col];
            if (digit != '.') {
                if (set.contains(digit)) {
                    return false;
                }
                set.add(digit);
            }
        }
        return true;
    }

    private boolean isValidSubgrid(char[][] board, int subgrid) {
        Set<Character> set = new HashSet<>();
        int rowStart = (subgrid / 3) * 3;
        int colStart = (subgrid % 3) * 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                char digit = board[i][j];
                if (digit != '.') {
                    if (set.contains(digit)) {
                        return false;
                    }
                    set.add(digit);
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        ValidSudoku obj = new ValidSudoku();
        char[][] board = {
                         {'8','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}
                         } ;

        System.out.println(obj.isValidSudoku(board));
    }
}
