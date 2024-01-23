// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {

    Set<Character>[] rows = new Set[9];
    Set<Character>[] cols = new Set[9];
    Set<Character>[] sqrs = new Set[9];

    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < rows.length; i++) rows[i] = new HashSet<>();
        for(int i = 0; i < cols.length; i++) cols[i] = new HashSet<>();
        for(int i = 0; i < sqrs.length; i++) sqrs[i] = new HashSet<>(); 

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                char c = board[i][j];
                if(c == '.') continue;

                if(rows[i].contains(c)) return false;
                else rows[i].add(c);

                if(cols[j].contains(c)) return false;
                else cols[j].add(c);

                int sqIdx = (3*(i/3)) + (j/3);
                if(sqrs[sqIdx].contains(c)) return false;
                else sqrs[sqIdx].add(c);
            }
        }

        return true;

    }
}
