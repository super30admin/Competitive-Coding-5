// Time Complexity: O(1) -> constant dimensions
// Space Complexity: O(1) -> constant dimensions

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;
        Set<String> set = new HashSet<>();

        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0; j < 9 ; j++){
                char currVal = board[i][j];
                if(currVal != null){
                    if(!set.add(currVal + " found in row " + i) || !set.add(currVal + " found in column " + j) ||
                    !set.add(currVal + " found in box " + i/3 + "-" + j/3)) return false;
                    set.add(currVal + " found in row " + i);
                    set.add(currVal + " found in column " + j);
                    set.add(currVal + " found in box " + i/3 + "-" + j/3);
                }
            }
        }
        return true;
    }
}
