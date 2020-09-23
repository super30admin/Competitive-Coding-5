
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// 	Very diffcult to predict.

// Your code here along with comments explaining your approach

class Solution {
    public boolean isValidSudoku(char[][] board) {
            // init data
    HashSet<Integer> [] rows = new HashSet[9];
    HashSet<Integer> [] columns = new HashSet[9];
    HashSet<Integer> [] boxes = new HashSet[9];
    for (int i = 0; i < 9; i++) {
      rows[i] = new HashSet<Integer>();
      columns[i] = new HashSet<Integer>();
      boxes[i] = new HashSet<Integer>();
    }

    // validate a board
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char num = board[i][j];
        if (num != '.') {
          int n = (int)num;
          int box_index = (i / 3 ) * 3 + j / 3;

         if((!rows[i].add(n))
                ||
            (!columns[j].add(n))
                ||
            (!boxes[box_index].add(n))){
                return false;
          }
            
        }
      }
    }

    return true;
    }
}