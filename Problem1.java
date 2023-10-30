// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j]!='.'){
                if(!(set.add(board[i][j]+" row found in "+i))||!(set.add(board[i][j]+" col found in "+j))||!(set.add(board[i][j]+" sub found in "+i/3+"-"+j/3)))
                return false;
            }
            }
        }
        return true;
    }
}