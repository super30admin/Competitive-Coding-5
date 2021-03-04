import java.util.*;

public class ValidSudoku {
	
    //TC - o(1) always 9*9 matrix so can be Considered constant
    //SC - o(1)
    public boolean isValidSudoku(char[][] board) {
        
        if(board == null || board.length == 0 )
            return false;
        
        //need diffrerent sets for each rows, cols, and boxes
        HashSet<Character> [] setR = new HashSet[9];
        HashSet<Character> [] setC = new HashSet[9];
        HashSet<Character> [] setB = new HashSet[9];
        
        int n = board.length;
        
        for (int i = 0; i < 9; i++) {
            setR[i] = new HashSet<Character>();
            setC[i] = new HashSet<Character>();
            setB[i] = new HashSet<Character>();
        }
        
        for(int i =0;i<n;i++){
            for (int j =0;j<n;j++) {
                //if it has digit check uniqueness
                if(board[i][j] != '.') {
                    int boxIndex = (i/3)*3+(j/3);
                    //if one of them contains the same character return false
                    if(setR[i].contains(board[i][j]) || setC[j].contains(board[i][j])
                      || setB[boxIndex].contains(board[i][j])) {
                        return false;
                    }
                    //else add it to the specific sets
                    else {
                        setR[i].add(board[i][j]);
                        setC[j].add(board[i][j]);
                        setB[boxIndex].add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }

}
