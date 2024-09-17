// Time Complexity : O(m x n) as we go through the matrix cell 3 times.
// Space Complexity : O(m x n) we're storing the elements in map
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach: separate maps for row, col and square. check if that element has occured

public class validSudoku {
        int m, n;
        public boolean isValidSudoku(char[][] board) {
            if(board == null || board.length == 0) return true;
            m = board.length;
            n = board[0].length;
            Set<Character> set;
            for(char[] row: board){
                set = new HashSet<>();
                for(char cell: row){
                    if(set.contains(cell))
                        return false;
                    if(cell != '.')
                        set.add(cell);
                }
            }

            for(int i = 0; i<m; i++){
                set = new HashSet<>();
                for(int j = 0; j<n; j++){
                    if(set.contains(board[j][i]))
                        return false;
                    if(board[j][i] != '.')
                        set.add(board[j][i]);
                }
            }
            return isBoxValid(board, 0,0, 2,2) && isBoxValid(board, 0,3, 2,5) && isBoxValid(board, 0,6, 2,8) &&
                    isBoxValid(board, 3,0, 5,2) && isBoxValid(board, 3,3, 5,5) && isBoxValid(board, 3,6, 5,8) &&
                    isBoxValid(board, 6,0, 8,2) && isBoxValid(board, 6,3, 8,5) && isBoxValid(board, 6,6, 8,8);
        }
        private boolean isBoxValid(char[][] board, int startRow, int startCol, int rows, int cols){
            Set set = new HashSet<>();
            for(int i=startRow; i<=rows; i++){
                for(int j = startCol; j<=cols; j++){
                    if(set.contains(board[i][j]))
                        return false;
                    if(board[i][j] != '.')
                        set.add(board[i][j]);
                }
            }
            return true;
        }
    }