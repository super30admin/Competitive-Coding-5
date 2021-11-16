// Time Complexity : O(n*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {
	 private char[] getColumn(char[][] board,int index) {
	        char[] newColumn = new char[board.length];
	        for(int i=0;i<board.length;i++) {
	            newColumn[i] = board[i][index];
	        }
	        return newColumn;
	    }
	    private boolean checkRow(char[] row) {
	        HashSet<Character> s = new HashSet<>();
	        int count = 0;
	        for(int i=0;i<row.length;i++) {
	            if(row[i] != '.') {
	                count++;
	                s.add(row[i]);
	            }
	        }
	        return count == s.size();
	    }
	    private char[] box(char[][] board,int row,int col) {
	        char[] temp = new char[board.length];
	        int k=0;
	        for(int i=row;i<row+3;i++) {
	            for(int j=col;j<col+3;j++) {
	                temp[k++]=board[i][j];
	            }
	        }
	        return temp;
	    }
	    public boolean isValidSudoku(char[][] board) {
	        // validate all rows
	        for(int i=0;i<board.length;i++) {
	            if(checkRow(board[i]) == false)
	                return false;
	        }
	        
	        // validate all columns
	        for(int i=0;i<board[0].length;i++) {
	            if(checkRow(getColumn(board,i)) == false)
	                return false;
	        }
	        
	        // validate sub boxes
	        for(int i=0;i<board.length;i=i+3) {
	            for(int j=0;j<board[i].length;j=j+3) {
	                if(checkRow(box(board,i,j)) == false)
	                    return false;
	            }
	        }
	        return true;
	    }
}
