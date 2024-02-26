// https://leetcode.com/problems/valid-sudoku/description/

// Time: O(MN) -> O(9*9) -> O(1)
// Space: O(3*M)-> O(3*M) -> O(3*9) -> O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    // Time Optimized
    // Time: O(MN) -> O(9*9) -> O(1)
    // Space: O(3*MN)-> O(3*9*9) -> O(1) 
    private boolean timeOptimized(char[][] board){
        int m=board.length;
        int n=board[0].length;

        // Sets for each row, col and block
        boolean[][] rowSet = new boolean[m][n];
        boolean[][] colSet = new boolean[m][n];
        boolean[][] blockSet = new boolean[m][n];

        // Iterate over the board
        // and check if an element is seen in row, col or block
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(board[row][col]=='.'){
                    continue;
                }

                int currNum=board[row][col]-'1';
                
                // Check if seen in 'row', if not mark as seen
                if(rowSet[row][currNum]){
                    return false;
                }else{
                    rowSet[row][currNum]=true;
                }

                // Check if seen in 'col', if not mark as seen
                if(colSet[col][currNum]){
                    return false;
                }else{
                    colSet[col][currNum]=true;
                }

                // Check if seen in 'block', if not mark as seen
                int blockNo = 3*(row/3) + (col/3);
                if(blockSet[blockNo][currNum]){
                    return false;
                }else{
                    blockSet[blockNo][currNum]=true;
                }
            }
        }

        return true;
    }

    // Time And Space Optimized
    // Time: O(MN) -> O(9*9) -> O(1)
    // Space: O(3*M)-> O(3*M) -> O(3*9) -> O(1)
    private boolean timeSpaceOptimized(char[][] board){
        int m=board.length;
        int n=board[0].length;

        // Iterate over the board
        // and check if an element is seen in row, col or block
        for(int row=0;row<m;row++){
            // Sets for each row, col and block
            boolean[] rowSet = new boolean[m];
            boolean[] colSet = new boolean[m];
            boolean[] blockSet = new boolean[m];

            for(int col=0;col<n;col++){
                
                // Check if seen in 'row', if not mark as seen
                if(board[row][col]=='.'){
                    // Do nothing
                }else if(rowSet[board[row][col]-'1']){
                    return false;
                }else{
                    rowSet[board[row][col]-'1']=true;
                }

                // Check if seen in 'col', if not mark as seen
                if(board[col][row]=='.'){
                    // Do nothing
                }else if(colSet[board[col][row]-'1']){
                    return false;
                }else{
                    colSet[board[col][row]-'1']=true;
                }

                // Check if seen in 'block', if not mark as seen
                int a=3*(row/3) + col/3;
                int b=3*(row%3) + col%3;
                if(board[a][b]=='.'){
                    //
                }else if(blockSet[board[a][b]-'1']){
                    return false;
                }else{
                    blockSet[board[a][b]-'1']=true;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        return timeOptimized(board);
    }
}