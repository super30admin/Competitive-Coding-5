// Time Complexity : O(9*9) = O(1)
// Space Complexity : O(9 * 3) = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer>[] cols = new HashSet[9];
        HashSet<Integer>[] blocks = new HashSet[9];
        int num;
        
        for(int i = 0 ; i < 9 ; i++){
            rows[i] = new HashSet<>(9);
            cols[i] = new HashSet<>(9);
            blocks[i] = new HashSet<>(9);
        }
        
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                if(board[i][j] != '.'){
                    num = board[i][j];
                    if(rows[i].contains(num) || cols[j].contains(num) || blocks[3*(i/3)+(j/3)].contains(num)) return false;
                    rows[i].add(num);
                    cols[j].add(num);
                    blocks[3*(i/3)+(j/3)].add(num);
                }
            }
        }
        return true;
    }
}
