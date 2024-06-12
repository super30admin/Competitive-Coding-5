package competitiveCoding5;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	//Time Complexity : O(n^2), where n are rows and columns. We need to traverse the entire matrix
	//Space Complexity : O(n^2), in worst case, we need to store all numbers in a set
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] row = new HashSet[9];
        Set<Integer>[] col = new HashSet[9];
        Set<Integer>[] box = new HashSet[9];
        
        for(int i=0; i<9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                if(board[i][j] != '.') {
                    char digit = board[i][j];
                    int num = digit - '0';
                    
                    if(row[i].contains(num))
                        return false;
                    else
                        row[i].add(num);
                    
                    if(col[j].contains(num))
                        return false;
                    else
                        col[j].add(num);
                    
                    int boxNo = ((i/3) * 3) + (j/3);
                    if(box[boxNo].contains(num))
                        return false;
                    else
                        box[boxNo].add(num);
                }
            }
        }
        
        return true;
    }
}
