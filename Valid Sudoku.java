//Time complexity = O(n^2)
//Space complexity = O(1)

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(!isValid(board,i,j)){
                    return false;
                }
            }
        }
        return true;
    }
    
   public static boolean notInRow(char[][] board, int row) {
        Set<Character> rowSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (rowSet.contains(board[row][i])) {
                return false;
            }

            if (board[row][i] != '.') {
                rowSet.add(board[row][i]);
            }
        }
        return true;
    }

    public static boolean notInCol(char[][] board, int col) {
        Set<Character> rowSet = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (rowSet.contains(board[i][col])) {
                return false;
            }

            if (board[i][col] != '.') {
                rowSet.add(board[i][col]);
            }
        }
        return true;
    }

    public static boolean notInBox(char[][] board, int row, int col) {
        Set<Character> rowSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (rowSet.contains(board[i + row][j + col])) {
                    return false;
                }
                if (board[i + row][j + col] != '.') {
                    rowSet.add(board[i + row][j + col]);
                }
            }
        }
        return true;
    }

    public static boolean isValid(char arr[][], int row, int col){
        return notInRow(arr, row) && notInCol(arr, col) && notInBox(arr, row - row % 3, col - col % 3);
    }

    
}