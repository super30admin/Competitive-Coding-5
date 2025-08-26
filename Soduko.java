class Soduko {
    //We traverse row 0 and col 0 at the same time and look for duplicate value using seperate hashset
    // We continue this seatch for all the rows and columns
    //If there are no duplicates, then we search each box for duplicates seperately using hashset
    //If there are no duplicates we return true else false

    //Since Input size is fixed. TC and SC is constant
    //Time Complexity : O(1)
    //Space Complexity : O(1)
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rowSet;
        HashSet<Character> colSet;
        for (int i = 0; i < 9; i++) {
            rowSet = new HashSet<>();
            colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (rowSet.contains(board[i][j])) {
                        return false;
                    }
                    rowSet.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (colSet.contains(board[j][i])) {
                        return false;
                    }
                    colSet.add(board[j][i]);
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                HashSet<Character> boxSet = new HashSet<>();
                for (int m = i; m < i + 3; m++) {
                    for (int n = j; n < j + 3; n++) {
                        if (board[m][n] != '.') {
                            if (boxSet.contains(board[m][n])) {
                                return false;
                            }
                            boxSet.add(board[m][n]);
                        }
                    }
                }
            }
        }
        return true;
    }
}