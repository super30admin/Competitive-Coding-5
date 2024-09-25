// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * https://leetcode.com/problems/valid-sudoku/
 * 
 *
 */
public class ValidSodoku {
	public boolean isValidSudoku(char[][] board) {
		if(board == null || board.length != 9 || board[0].length != 9) return false;

		//check row
		for(int i=0; i<9; i++) {
			boolean[] seen = new boolean[9];

			for(int j=0; j<9;j++){
				if(Character.isDigit(board[i][j])){
					if(seen[Integer.parseInt(Character.toString(board[i][j])) - 1]){
						return false;  
					}
					seen[Integer.parseInt(Character.toString(board[i][j])) - 1] = true; 
				}

			}
		}

		//check column
		for(int i=0; i<9; i++) {
			boolean[] seen = new boolean[9];

			for(int j=0; j<9;j++){
				if(Character.isDigit(board[j][i])){
					if(seen[Integer.parseInt(Character.toString(board[j][i])) - 1]){
						return false;  
					}
					seen[Integer.parseInt(Character.toString(board[j][i])) - 1] = true; 
				}
			}
		}

		//check sub boxes
		//using block numbers, find bounds for the sub boxes
		for(int block =0 ; block < 9; block++) {
			boolean[] seen = new boolean[9];
			for(int i= block/3*3; i< block/3*3+3; i++) {
				for(int j=block%3*3; j<block%3*3+3;j++){
					if(Character.isDigit(board[i][j])){
						if(seen[Integer.parseInt(Character.toString(board[i][j])) - 1]){
							return false;  
						}
						seen[Integer.parseInt(Character.toString(board[i][j])) - 1] = true; 
					}
				}
			}
		}

		return true;
	}
}
