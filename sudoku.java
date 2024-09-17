// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//TC: O(1)
//SC: O(1)
class Solution{
    public boolean isValidSudoku(char[][] board) {
    if(board == null || board.length!=9 || board[0].length != 9) return false;
        for(int row = 0; row < 9; row ++){
            boolean[] b = new boolean[9];
            for(int col = 0; col < 9;col ++){
            if(board[row][col] != '.'){
                if(b[(int)(board[row][col]-'1')])return false;
                b[(int)(board[row][col]-'1')] = true; }}}
        for(int col = 0;col < 9;col ++){
            boolean[] b = new boolean[9];
            for(int row = 0;row < 9;row++){
            if(board[row][col] != '.')
            {
                if(b[(int)(board[row][col]-'1')])return false;
                b[(int)(board[row][col]-'1')] = true; }}}
        for(int block = 0; block < 9; block ++ )
        {boolean[] b = new boolean[9];
            for(int row = block/3*3;row<block /3*3+3;row++){
            
            for(int col=block%3*3;col<block %3*3 + 3;col++){
            if(board[row][col] != '.')
            {
                if(b[(int)(board[row][col]-'1')])return false;
                b[(int)(board[row][col]-'1')] = true; }}
        
            }}
         return true;
    }
}