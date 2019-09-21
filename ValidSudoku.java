// author: yash pradhan
//
// Idea: 
// isValidSudoku calls checkAllRows, checkAllCols & checkAllSubgrids for given board.
// checkAllRows calls checkRow for each row
// checkAllCols calls checkCol for each col
// checkAllSubgrids calls checkSubgrid for each subgrid

// Time Complexity: O(1)
// Space Complexity: O(1)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        return checkAllRows(board) && checkAllCols(board) && checkAllSubgrids(board);
    }
    
    private boolean checkAllRows(char[][] board) {
        for(int i = 0; i < 9; i++) {
            if(checkRow(board, i) == false) {
                return false;    
            }
        }
        return true;
    }
    
    private boolean checkRow(char[][] board, int i) {
        Set<Character> set = new HashSet<>();
        for(int j = 0; j < 9; j++) {
            if(board[i][j] == '.') continue;
            if(set.contains(board[i][j])) {
                return false;
            } 
            set.add(board[i][j]);
        }
        return true;
    }
    
    private boolean checkAllCols(char[][] board) {
        for(int j = 0; j < 9; j++) {
            if(checkCol(board, j) == false) {
                return false;
            }
        }
        return true;
    }
    
    private boolean checkCol(char[][] board, int j) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            if(board[i][j] == '.') continue;
            if(set.contains(board[i][j])) {
                return false;
            } 
            set.add(board[i][j]);
        }
        return true;
    }
    
    private boolean checkAllSubgrids(char[][] board) {
        for(int i = 0; i < 9; i+=3) {
            for(int j = 0; j < 9; j+=3) {
                if(checkSubgrid(board, i, j) == false) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean checkSubgrid(char[][] board, int i, int j) {
        Set<Character> set = new HashSet<>();
        for(int x = i; x < i + 3; x++) {
            for(int y = j; y < j+3; y++) {
                if(board[x][y] == '.') continue;
                if(set.contains(board[x][y])) {
                    return false;
                } 
                set.add(board[x][y]);
            }
        }
        return true;
    }
}