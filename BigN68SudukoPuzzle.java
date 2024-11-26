// Time complexity is o(n^2) as row and column are same.
// Space complexity is O(n) as we are boolean arrays
// This solution is submitted on leetcode

public class BigN68SudukoPuzzle {
	class Solution {
		public boolean isValidSudoku(char[][] board) {
			// edge case
			if (board == null || board.length != 9 || board[0].length != 9)
				return false;
			// row checking
			for (int i = 0; i < 9; i++) {
				boolean[] check = new boolean[9];
				for (int j = 0; j < 9; j++) {
					if (board[i][j] != '.') {
						// beaware to subtract -1 and '1' as it is an char array
						if (check[(int) board[i][j] - '1'] == true)
							return false;
						check[(int) board[i][j] - '1'] = true;
					}
				}
			}

			// column checking
			for (int j = 0; j < 9; j++) {
				boolean[] checker = new boolean[9];
				for (int i = 0; i < 9; i++) {
					if (board[i][j] != '.') {
						if (checker[(int) board[i][j] - '1'] == true)
							return false;
						checker[(int) board[i][j] - '1'] = true;
					}
				}
			}
			// grid checking
			for (int block = 0; block < 9; block++) {
				boolean[] gridChecker = new boolean[9];
				for (int i = 3 * (block / 3); i < 3 * (block / 3) + 3; i++) {
					for (int j = 3 * (block % 3); j < 3 * (block % 3) + 3; j++) {
						if (board[i][j] != '.') {
							if (gridChecker[(int) board[i][j] - '1'] == true)
								return false;
							gridChecker[(int) board[i][j] - '1'] = true;
						}
					}
				}
			}
			return true;
		}
	}
}