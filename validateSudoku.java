// Time Complexity: O(n) as all nodes will be traversed only once
// Space Complexity: 3sets of O(n) space complexity is used
// Did you complete it on leetcode: Yes
// Any problems faced: Couldn'tcome up with box formula on my own

// Write your approach:
// Idea here is to navigate through each cell to determing if that value is present in current row by using rowSet for each Row.
// Similarly a column set is used to check each column by inverting row and column index pointers
// for box we divide whole matrix into 3*3 boxes and identify by outer index which box cell belongs to and also check the inner cells by using j's row and cell /3 and %3 and adding to box number. If it already exist in box set return false
// else return valid.
class Solution {
    public boolean isValidSudoku(char[][] board) {
       for(int i=0; i<9; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> boxSet = new HashSet<>();
            for(int j = 0; j<9; j++) {
                if(board[i][j]!='.' && !rowSet.add(board[i][j])) return false;
                if(board[j][i]!='.' && !colSet.add(board[j][i])) return false;
                int rIdx = 3*(i/3);
                int cIdx = 3*(i%3);
                if(board[rIdx+(j/3)][cIdx+(j%3)]!='.' && !boxSet.add(board[rIdx+(j/3)][cIdx+(j%3)])) return false;
            }
        }
        return true;
    }
}