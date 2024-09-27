/**
// Time Complexity : O(mn)
// Space Complexity : O(mn) worst case filled sudoku
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
//yes finding the calc for block.

// Your code here along with comments explaining your approach
// store all seened values in hash set with val + r/c = x and val+ b : y
//format. see if this format already exists for a val. we know its seen.
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hset = new HashSet<>();
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[0].length; j++){
                if(board[i][j] != '.'){
                    if(!hset.add(board[i][j]+" r:"+i) ||
                       !hset.add(board[i][j]+" c:"+j) ||
                       !hset.add(board[i][j]+" b:"+i/3+j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
