// Time Complexity :  O(1) - 3 x O(9*9)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        for (int i=0; i<9; i++){
            int[] carr = new int[9];
            for (int j=0; j<9; j++){
                if (board[i][j] != '.') {
                    if (carr[board[i][j]-'1'] == 1){
                        return false;
                    } else {
                        carr[board[i][j]-'1'] = 1;
                    }
                }
            }
        }
        
        for (int j=0; j<9; j++){
            int[] rarr = new int[9];
            for (int i=0; i<9; i++){
                if (board[i][j] == '.') continue;
                if (rarr[board[i][j]-'1'] == 1){
                    return false;
                } else {
                    rarr[board[i][j]-'1'] = 1;
                }
            }
        }

        Set<String> set = new HashSet<>();
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                char ch = board[i][j];
                if (board[i][j] == '.') continue;
                  if (set.contains(ch+""+""+i/3+""+j/3)) {
                      return false;
                  }
                  set.add(ch+""+""+i/3+""+j/3);
            }
        }
        return true;
    }
}