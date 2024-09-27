// Time Complexity : O(N x M) as we go through the board once.
// Space Complexity : O(N x M) asymptotically as we create the hashSets in our solution.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes alot actually. I came up with the solution 
        //where we can go through the board 3 times once for checking if rows are valid,
        //once to check if columns were valid and once for all the grids
        //But the interviewer asked me if I can do it in one pass by using extra space.
        //I messed up in creating the logic of creating and maintaining so many hashmaps.

import java.util.*;

public class ValidSudoku {

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            if(board == null || board.length == 0 || board[0].length == 0) {
                return false;
            }
            
            int n = board.length;
            int m = board[0].length;
            
            List<Set<Character>> rows = new ArrayList<>();
            List<Set<Character>> cols = new ArrayList<>();
            List<Set<Character>> grids = new ArrayList<>();
            
            for(int i = 0; i < board.length ; i++) {
                rows.add(new HashSet<>());
                cols.add(new HashSet<>());
                
                if(i < 3) {
                    grids.add(new HashSet<>());
                }
            }
        
            for(int i = 0; i < n ; i++) {
                if(i == 3 || i == 6) {
                    reSetGrids(grids);
                }
                
                for(int j = 0; j < m; j++) {
                    if(board[i][j] == '.') {
                        continue;
                    }
                    
                    if(rows.get(i).contains(board[i][j])) {
                        return false;
                    } else {
                        rows.get(i).add(board[i][j]);
                    }
                    
                    if(cols.get(j).contains(board[i][j])) {
                        return false;
                    } else {
                        cols.get(j).add(board[i][j]);
                    }
                    
                    int grid = j/3;
                    if(grids.get(grid).contains(board[i][j])) {
                        return false;
                    } else {
                        grids.get(grid).add(board[i][j]);
                    }
                }
            }
            
            return true;
        }
        
        private void reSetGrids(List<Set<Character>> grids) {
            for(int x = 0; x < 3; x++) {
                grids.set(x, new HashSet<>());
            }
        }
    }
}
