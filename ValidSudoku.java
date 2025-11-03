// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] column = new HashSet[9];
        HashSet<Character>[] box = new HashSet[9];

        for ( int i=0;i<9;i++){
            row[i] = new HashSet<>();
            column[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char cell = board[i][j];
                if(cell == '.') continue;
                int index = (i/3) *3 + (j/3);
                if(row[i].contains(cell) || column[j].contains(cell) || box[index].contains(cell))  return false;
                row[i].add(cell);
                column[j].add(cell);
                box[index].add(cell);
            }
        }
        return true;
    }
}
