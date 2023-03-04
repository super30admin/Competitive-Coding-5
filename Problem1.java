import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/*
Valid Sudoku
approach: we'll traverse 9x9 in terms of 3x3 sub-boxes. we'll keep track of rownums and colnums, if any of the element is in rownums
or colnums, return false; also, check if it is already in the current sub-box.
time: O(nxn)
space: O(nxn)
 */
public class Problem1 {
    List<HashSet<Character>> rownums;
    List<HashSet<Character>> colnums;
    public boolean isValidSudoku(char[][] board) {
        if(board==null) return false;
        int rows = board.length, cols = board[0].length;
        rownums = new ArrayList<>();
        colnums = new ArrayList<>();
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                rownums.add(new HashSet<>());
                colnums.add(new HashSet<>());
            }
        }
        for(int i=0;i<rows;i = i+3) {
            for(int j=0;j<cols;j = j+3) {
                if (!check(board, i, j)) return false;
            }
        }

        return true;
    }

    private boolean check(char[][] board, int r, int c) {
        boolean[] chars = new boolean[9];

        for(int i=r;i<r+3;i++) {
            for(int j = c;j<c+3;j++) {
                char curr = board[i][j];
                if(curr=='.') continue;
                //check if it is present in sub-box
                if(curr-'1'<0 || curr-'1'>8 || chars[curr-'1']) return false;
                chars[curr-'1'] = true;
                //check in rows or cols
                if(rownums.get(i).contains(curr)) return false;
                if( colnums.get(j).contains(curr)) return false;
                rownums.get(i).add(curr);
                colnums.get(j).add(curr);
            }
        }
        return true;
    }

    public static void main(String []args) {
        Problem1 problem1 = new Problem1();
        problem1.isValidSudoku(new char[][]{{'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        });
    }
}
