class Solution {

    // Time Complexity : 0(m*n) where m is the row and n is the column
// Space Complexity : 0(m*n) where m is the row and n is the column
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];     //initializing a hashset at each and every row, column and a block
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Character>(); //initializing a hashset to store all the different values
            cols[i] = new HashSet<Character>();
            boxes[i] = new HashSet<Character>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {       //running for loop for each and every element
                char val = board[i][j];     //storing the value of the index in a char array
                if (val == '.') {       //checking if the block is '.' or not
                    continue;
                }
                if (rows[i].contains(val)) {//if the value is already present and encountered again, then returning false as it is duplicate value
                    return false;
                }
                rows[i].add(val);   //if the value is encountered for 1st time then adding it to my hashset
                if (cols[j].contains(val)) {    //repeating the above procedure for columns and blocks
                    return false;
                }
                cols[j].add(val);
                int idx = (i / 3) * 3 + j / 3;
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;    //if false is not returned means all the conditions are fulfilled and true is returned
    }
}