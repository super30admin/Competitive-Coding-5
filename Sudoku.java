/*The time and space complexity of this implementation is O(1)*/
class Sudoku {
    public boolean isValidSudoku(char[][] board) {
        // Check each row
        for (int row = 0; row < 9; row++) {
            boolean[] used = new boolean[9];
            for (int col = 0; col < 9; col++) {
                char digit = board[row][col];
                if (digit != '.') {
                    if (used[digit - '1']) {
                        return false;
                    }
                    used[digit - '1'] = true;
                }
            }
        }

        // Check each column
        for (int col = 0; col < 9; col++) {
            boolean[] used = new boolean[9];
            for (int row = 0; row < 9; row++) {
                char digit = board[row][col];
                if (digit != '.') {
                    if (used[digit - '1']) {
                        return false;
                    }
                    used[digit - '1'] = true;
                }
            }
        }

        // Check each sub-box
        for (int box = 0; box < 9; box++) {
            boolean[] used = new boolean[9];
            int rowOffset = (box / 3) * 3;
            int colOffset = (box % 3) * 3;
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    char digit = board[rowOffset + row][colOffset + col];
                    if (digit != '.') {
                        if (used[digit - '1']) {
                            return false;
                        }
                        used[digit - '1'] = true;
                    }
                }
            }
        }

        // All rows, columns, and sub-boxes are valid
        return true;
    }


    public static void main(String[] args) {
        // Example usage
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Sudoku solution = new Sudoku();
        boolean isValid = solution.isValidSudoku(board);
        System.out.println(isValid); // should print true
    }
}

