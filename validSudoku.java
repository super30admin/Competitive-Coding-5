import java.util.*;

class Main {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        // arrays of HashSet
        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];
        // intialize the hashSets
        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Character.isDigit(board[i][j])) {
                    // check rows set if already contains we return false
                    // or add it into the set
                    if (rows[i].contains(board[i][j])) {
                        return false;
                    } else {
                        rows[i].add(board[i][j]);
                    }

                    // check cols set if already contains we return false
                    // or add it into the set
                    if (cols[j].contains(board[i][j])) {
                        return false;
                    } else {
                        cols[j].add(board[i][j]);
                    }
                    // check boxes for that I am counting box number from left to right and top to
                    // bottom

                    int boxNum = (i / 3) * 3 + (j / 3);
                    if (boxes[boxNum].contains(board[i][j])) {
                        return false;
                    } else {
                        boxes[boxNum].add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}