// Time Complexity : o(n*n) where n is 3
// Space Complexity :  o(n*n) where n is 3 or number of non empty cells
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach :  for every cell value check in the row, column and box set if its present then retrun false.
class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<String> set = new HashSet<>();

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){

                if(board[i][j] == '.') continue;

                String row = "r" + i + board[i][j];
                String column = "c" + j + board[i][j];
                String box = "b" + getBoxId(i,j) + board[i][j];

                if(set.contains(row) || set.contains(column) || set.contains(box)){
                    return false;
                }

                set.add(row);
                set.add(column);
                set.add(box);
            }
        }

        return true;
    }

    public int getBoxId(int i , int j){
        return 3*(i/3) + j/3;
    }
}
