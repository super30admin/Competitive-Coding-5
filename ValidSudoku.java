// Time Complexity : O(M*N) //m rows and n cols
// Space Complexity :O(M*N) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


/*
 * 1. For each row maintain a visited array and validate row to not have duplicates
 * 2. Maintain column wise two dimensional array to check each column does not have duplicates
 * 3. for each 3*3 matrix mid element check 3*3 array does not have duplicates.
 */

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {

		int[][] dir = new int[][] { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 },
				{ 1, 1 } ,{0,0}};

		int[][] colvisited = new int[board[0].length][board.length];

		for (int i = 0; i < board.length; i++) {
			int[] rowvisited = new int[board[0].length];
			for (int j = 0; j < board[0].length; j++) {
				if (Character.isDigit(board[i][j])) {
					int k = board[i][j] - '0';
					//row check
					if (rowvisited[k - 1] == 0) {
						rowvisited[k - 1] = 1;
						//column check
						if (colvisited[j][k - 1] == 0) {
							colvisited[j][k - 1] = 1;
						} else {
							return false;
						}

					} else {
						return false;
					}

				}

				// 3*3 validation
				if (i % 3 == 1 && j % 3 == 1) {
					int[] visited = new int[board.length];
					for (int l = 0; l < dir.length; l++) {
						int row = i + dir[l][0];
						int col = j + dir[l][1];
						if (Character.isDigit(board[row][col])) {
							int c = board[row][col] - '0';
							if (visited[c - 1] == 0) {
								visited[c - 1] = 1;
							} else {
								return false;
							}
						}
					}
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		char[][] board = new char[][] { { '9', '.', '.', '6', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '6', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '1', '.', '3', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '8' }, { '.', '.', '.', '.', '.', '8', '.', '.', '.' },
				{ '.', '.', '.', '4', '.', '.', '2', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '1' },
				{ '6', '.', '.', '.', '1', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' } };
		System.out.println(new ValidSudoku().isValidSudoku(board));
	}
}
