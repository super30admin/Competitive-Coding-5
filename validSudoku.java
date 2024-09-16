// Time Complexity : O(9 * 9)= O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
        
        for(int i = 0; i < 9; i++) {
            columns[i] = new HashSet();
            rows[i] = new HashSet();
            boxes[i] = new HashSet();
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.') {
                    int box_index = (i / 3) * 3 + j / 3;
                    if(boxes[box_index].contains(board[i][j])
                        || columns[j].contains(board[i][j])
                        || rows[i].contains(board[i][j]))
                        return false;
                    else {
                        boxes[box_index].add(board[i][j]);
                        columns[j].add(board[i][j]);
                        rows[i].add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}