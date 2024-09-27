import java.util.HashSet;

// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

public class ValidSudoku {

    class Solution {
        public boolean isValidSudoku(char[][] board) {

            //save value as a string to minimize using more than one hashset
            HashSet<String> visited = new HashSet<>();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {

                    char currValue = board[i][j];
                    //add to hashset if array is not empty
                    if(currValue != '.'){
                        //return false if same value is being added to a row, column, or sub cube
                        if(!visited.add(currValue + "in row" + i)||
                                !visited.add(currValue + "in column"+ j)||
                                                !visited.add(currValue + "in sub box" + i/3 + "-" + j/3)){
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
}
