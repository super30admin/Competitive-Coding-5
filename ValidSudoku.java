//Time Complexity: O(1)
//Space Complexity: 3 * O(n)
class Solution {
    public boolean isValidSudoku(char[][] board) {

        //Validate inputs
        if(board == null || board.length != 9) return false;

        // Initialize three arrays for rows, cols and grid
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for(int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];

                if(c == '.') continue;

                int bIdx = (i / 3) * 3 + (j / 3);
                if (rows[i].contains(c) || cols[j].contains(c) || boxes[bIdx].contains(c)){
                    return false;
                }
                rows[i].add(c);
                cols[j].add(c);
                boxes[bIdx].add(c);
            }
        }
        return true;
    }
}