class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i =0; i<board.length;i++) {
            for(int j =0; j<board[0].length;j++) {
                if(board[i][j] != '.') {
                    if(set.contains(" row " + board[i][j] + i) || set.contains(" column " + board[i][j] + j) || set.contains(" box " + board[i][j] + i/3 + j/3)) {
                        return false;
                    } else {
                        set.add(" row " + board[i][j] + i);
                        set.add(" column " + board[i][j] + j);
                        set.add(" box " + board[i][j] + i/3 + j/3);
                        
                    }
                    
                }
                
            }
        }
        return true;
    }
}