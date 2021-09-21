// TIME: O(N^2)
// SPACE: O(N^2)
// SUCCESS on LeetCode

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
        
        for (int r = 0; r < 9; r++) {
            rows[r] = new HashSet<>();
            cols[r] = new HashSet<>();
            boxes[r] = new HashSet<>();
        }
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                
                if (val == '.') continue;
                
                if (rows[r].contains(val)) return false;
                rows[r].add(val);
                if (cols[c].contains(val)) return false;
                cols[c].add(val);
                int boxIndex = (r/3) * 3 + c/3;
                if (boxes[boxIndex].contains(val)) return false;
                boxes[boxIndex].add(val);
            }
        }
        
        return true;
    }
}
