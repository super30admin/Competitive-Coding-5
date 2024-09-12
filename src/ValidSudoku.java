// Time Complexity:  O(m*n)
// Space Complexity: O(m*n)

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]!='.') {
                    if(
                        !set.add("Row " + i + " " + board[i][j]) ||                           // unique for each row 
                        !set.add("Column " + j + " " + board[i][j]) ||                        // unique for each column
                        !set.add("Box "+ ((i/3)*3)/3 + " " + j/3 + " " + board[i][j])         // unique for each box
                    )
                    return false;
                }
            }
        }
        return true;
    }
}
