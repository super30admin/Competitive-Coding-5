// TC: O(1) since the board is 9*9
// SC : O(1) since we are using constant space for the 2D array.

// I am storing the index of row and that digit as row and column index for a 2D array which will be set to true if its being visited for first time. If the row index and digit has already been set to true, we return false since it is being appeared again
// I am storing the digit and that digit index column as row and column index for a 2D array which will be set to true if its being visited for first time. If the column index and digit has already been set to true, we return false since it is being appeared again
// I am storing the index of row/3, column/3(since we are checking 3*3 grid) and that digit as row, column index for a 3D array which will be set to true if its being visited for first time. If the row index and digit has already been set to true, we return false since it is being appeared again

public class validSudoku {

	public boolean ValidSudoku(char[][] board) {
		
		boolean[][] rows = new boolean[9][9];
		boolean[][] cols = new boolean[9][9];
		boolean[][][] grid = new boolean[3][3][9];
		
		for(int i = 0;i < 9;i++) {
			for(int j = 0;j < 9;j++) {
				
				if(board[i][j]=='.')
					continue;
				
				int digit = board[i][j] - '1';
				
				if(rows[i][digit] == false)
					rows[i][digit] = true;
				else
					return false;
				
				if(cols[digit][j] == false)
					cols[digit][j] = true;
				else
					return false;
				
				if(grid[i/3][j/3][digit] == false)
					grid[i/3][j/3][digit] = true;
				else
					return false;
			}
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		
		validSudoku vs = new validSudoku();
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(vs.ValidSudoku(board));
		
	}
}
