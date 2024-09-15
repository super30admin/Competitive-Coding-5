// Time Complexity : O(m*n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidSudoku(char[][] board) {
    HashSet<String> h1 = new HashSet<String>();

        for(int i=0; i < 9; i++){
            for(int j=0; j< 9; j++){
                if(board[i][j] != '.'){

                if(h1.contains("row" + i + board[i][j]) || h1.contains("col" + j + board[i][j]) ){
                    return false;
                }
                h1.add("row" + i + board[i][j]);
                h1.add("col" + j + board[i][j]);

                if(h1.contains("box"+ (i/3)*3 + j/3 + board[i][j])){
                    return false;
                }
                h1.add("box"+ (i/3)*3 + j/3 + board[i][j]);
                }
            }
        }
        return true;
    }
}