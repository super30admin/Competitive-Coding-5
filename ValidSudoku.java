// Time Complexity : O(1) + O(1) + O(1)
// Space Complexity : O(m*n) + O(m*n) + O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
I have used three for loops. First to check unique numbers in a row, 
second to check unique numbers in column and third to check unique 
numbers in the box
*/

class ValidSudoku {
     public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length != 9)
            return false;

        //check if dulpicate present in row
        for (int row = 0; row < 9; row++) {
            int[] visited = new int[9];

            for (int col = 0; col < 9; col++) {

                //if its not empty cell
                if (board[row][col] != '.') {
                    int val = board[row][col] - '0';
                    if (visited[val - 1] == 1) return false;
                    visited[val - 1] = 1;
                }
            }
        }

        //check if dulpicate present in col
        for (int col = 0; col < 9; col++) {
            int[] visited = new int[9];

            for (int row = 0; row < 9; row++) {

                //if its not empty cell
                if (board[row][col] != '.') {
                    int val = board[row][col] - '0';
                    if (visited[val - 1] == 1) return false;
                    visited[val - 1] = 1;
                }
            }
        }

        //check if dulpicate present in box
        for (int block = 0; block < 9; block++) {
            int[] visited = new int[9];

            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {

                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {

                    //if its not empty cell
                    if (board[i][j] != '.') {
                        int val = board[i][j] - '0';
                        if (visited[val - 1] == 1) return false;
                        visited[val - 1] = 1;
                    }
                }
            }
        }
        return true;
    }
}