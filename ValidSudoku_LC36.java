// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NONE

class ValidSudoku_LC36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] columns = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int n = 0; n < 9; n++) {
            rows[n] = new HashSet<>();
            columns[n] = new HashSet<>();
            boxes[n] = new HashSet<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char val = board[i][j];
                
                if (val == '.') continue;

                if (rows[i].contains(val)) return false;
                rows[i].add(val);

                if (columns[j].contains(val)) return false;
                columns[j].add(val);

                int bx = ((i / 3) * 3) + (j / 3);
                if (boxes[bx].contains(val)) return false;
                boxes[bx].add(val);
            }    
        }

        return true;
    }
}