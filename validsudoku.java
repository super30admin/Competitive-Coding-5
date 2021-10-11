
//time complexity: O(m*n)
//space complexity: O(1)

//we will go each row, column and a 3*3 block matrix to check whether all the numbers from 0 to 9 are present without any duplicates
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
		return false;

	// checking each column
	for (int i = 0; i < 9; i++) {
		boolean[] m = new boolean[9];
		for (int j = 0; j < 9; j++) {
			if (board[i][j] != '.') {
				if (m[(int) (board[i][j] - '1')]) {
					return false;
				}
				m[(int) (board[i][j] - '1')] = true;
			}
		}
	}
 
	//checking each row
	for (int j = 0; j < 9; j++) {
		boolean[] m = new boolean[9];
		for (int i = 0; i < 9; i++) {
			if (board[i][j] != '.') {
				if (m[(int) (board[i][j] - '1')]) {
					return false;
				}
				m[(int) (board[i][j] - '1')] = true;
			}
		}
	}
 
	//checking each 3*3 matrix
	for (int block = 0; block < 9; block++) {
		boolean[] m = new boolean[9];
		for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
			for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
				if (board[i][j] != '.') {
					if (m[(int) (board[i][j] - '1')]) {
						return false;
					}
					m[(int) (board[i][j] - '1')] = true;
				}
			}
		}
	}
 
	return true;
    }
}