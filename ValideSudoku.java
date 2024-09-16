// Time Complexity : O(n^2) where n is 9 in this case
// Space Complexity : O(n^2) where n is 9 in this case
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
public class ValideSudoku {
    
}
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null){
            return true;
        }
        int n = 9;
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                char val = board[i][j];
                //set.add returns false if value already exists in set
                // key "row:"+i+":"+val keeps track of uniqueness of values in each row
                // key "col:"+j+":"+val keeps track of uniqueness of values in each column
                // key "grid"+i/3+":"+j/3+":"+val keeps track of uniqueness of value in each smaller 3x3 grid
                if(!set.add("row:"+i+":"+val) ||
                  !set.add("column"+j+":"+val) ||
                  !set.add("grid"+i/3+":"+j/3+":"+val)){
                    return false;
                }
                
            }
        }
        return true;
    }
}
