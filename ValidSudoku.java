// Approach :
// Time : Constant or O(nx2)
// Space : Extra space for set
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        // fixed board length = 9
        for(int i =0;i<9;i++){
            for (int j=0;j<9;j++){
                // check only filled cells
                if(board[i][j] != '.'){
                    char curr = board[i][j];
                    // If we have a duplicate in the row
                    // If we have a duplicte in the column
                    // If we have a duplicate in the block
                    if(!seen.add(curr + "at row" + i) || !seen.add(curr + "at col" + j) || !seen.add(curr + "at block" + i/3 + "-" + j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}