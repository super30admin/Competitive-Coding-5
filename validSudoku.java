// Time Complexity : O(k), where k=81 cells
// Space Complexity : O(k), for the hashSet
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9) return false;

        Set<String> set = new HashSet<>();

        // Itterate over each cell in the 2D matrix and check if its value is unique across the row, colomn and box.
        // To check for the uniqueness we add it to the set with a prepended string: 1) For row: "row"+i+board[i][j], 2) For col: "col"+j+board[i][j]
        // 3) For box: "box"+(i/3)*3+j/3+board[i][j].... Here (i/3)*3+j/3 will give you the box number 0-9
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] != '.') {
                    if (!set.add("row"+i+board[i][j]) || !set.add("col"+j+board[i][j])) { // For row and col
                        return false;
                    }
                    if (!set.add("box"+(i/3)*3+j/3+board[i][j])) { // For sub-box
                        return false;
                    }
                }
            }
        }

        return true;
    }
}