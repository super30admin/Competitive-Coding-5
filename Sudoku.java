import java.util.HashSet;
import java.util.Set;

public class Sudoku {


    // Because of the HashSet, it takes a lot of time to execute. The reason is we are generating a hash of each string.
    // There are 9 * 9 * 9 = 721 (total rows * total columns * total boxes) strings to hash

    // TC: O(m * n) m - number of rows   n - number of columns
    // SC: O(m * n)
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0) return false;

        // Set will hold the element in row, column and a box
        // This will help us to identify the duplicates
        Set<String> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char value = board[i][j];

                if (value != '.') {
                    int boxBase = i / 3 * 3; // This will be any one of these -> 0, 3, 6
                    int verticalPosition = j / 3; // This will be also any one of these -> 0, 3, 6
                    int boxNumber = boxBase + verticalPosition;

                    if (set.contains("r" + i + value) ||
                            set.contains("c" + j + value) ||
                            set.contains("b" + boxNumber + value)) {
                        return false;
                    } else {
                        set.add("r" + i + value);
                        set.add("c" + j + value);
                        set.add("b" + boxNumber + value);
                    }
                }
            }
        }

        return true;
    }

    // This approach avoids the use of HashSet. SO, it is faster than the above.
    // TC: O(m * n) m - number of rows   n - number of columns
    // SC:
    //      (rows * 10) + (columns * 10) + (number of boxes * 10)
    //      since, the number of rows / columns / boxes are 9
    //     the complexity would be 9 * 10 * 3 i.e. O(m * 10 * 3) = O(m)
    public boolean isValidSudoku2(char[][] board) {
        if(board == null || board.length == 0) return false;

        // These 2-D matrices will be used to mark the number as visited within a row / column / box
        int[][] rows = new int[board.length][10]; // 9 - number of rows  10 - number can be between 1 and 9
        int[][] columns = new int[board[0].length][10]; // same as above
        int[][] box = new int[rows.length * columns.length / 9][10]; // each box is of 3 * 3

        for(int i=0; i < board.length; i++) {
            for(int j=0; j < board[0].length; j++) {
                char value = board[i][j];

                if(value != '.') {
                    //The char data type is a single 16-bit Unicode character.
                    // Its value-range lies between ‘\u0000’ (or 0) to ‘\uffff’ (or 65,535 inclusive)
                    int number = value - '0';

                    int boxBase = i / 3 * 3; // This will be any one of these -> 0, 3, 6
                    int verticalPosition = j / 3; // This will be also any one of these -> 0, 3, 6
                    int boxNumber = boxBase + verticalPosition;

                    rows[i][number] += 1;
                    columns[j][number] += 1;
                    box[boxNumber][number] += 1;

                    if(rows[i][number] > 1 ||
                            columns[j][number] > 1 ||
                            box[boxNumber][number] > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }

}
