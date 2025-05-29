import java.util.HashSet;
import java.util.Set;

public class problem2 {
// Time Complexity: O(1)
    // Space Complexity: O(1)
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows= new HashSet[9];
        Set<Character>[] cols= new HashSet[9];
        Set<Character>[] boxes= new HashSet[9];

        for (int i=0;i<9;i++)
        {
            rows[i]= new HashSet<>();
            cols[i]= new HashSet<>();
            boxes[i]= new HashSet<>();

        }
        for (int i=0;i<board.length;i++)
        {
            for (int j=0;j<board[i].length;j++)
            {
                char c= board[i][j];
                if (c!='.') {
                    if (!isValid(rows[i], board[i][j])) {
                        return false;
                    }
                    if (!isValid(cols[j], board[i][j])) {
                        return false;
                    }
                    if (isValid(boxes[boxIndex(i,j)], c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValid(Set<Character> set, char c)
    {
        if (set.contains(c))
        {return false;}
        set.add(c);
        return true;
    }

    public int boxIndex(int row, int col){
        return (row/3) *3 + col/3;
    }

}
