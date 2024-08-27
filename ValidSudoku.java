//Time Complexity: O(1)
//Space Complexity: O(1)
import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[] grid = new HashSet[9];
        for(int i=0;i<9;i++){
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            grid[i] = new HashSet<>();
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char firstVal = board[i][j];
                if(!Character.isDigit(firstVal)){
                    continue;
                }
                int boxId = (i/3)*3 + (j/3);
                if(rows[i].contains(firstVal) || columns[j].contains(firstVal) || grid[boxId].contains(firstVal)) return false;

                rows[i].add(firstVal);
                columns[j].add(firstVal);
                grid[boxId].add(firstVal);

            }
        }
        return true;
    }
}
