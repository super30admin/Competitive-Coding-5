// Time Complexity : O(n*n), n -> Length of board
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		if (board == null || board.length == 0) {
			return false;
		}

		Set<String> set = new HashSet<String>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == '.') {
					continue;
				}

				if (!set.add("Row_" + i + "_" + board[i][j]) || !set.add("Col_" + j + "_" + board[i][j])
						|| !set.add("Block_" + i / 3 + "_" + j / 3 + "_" + board[i][j])) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		ValidSudoku obj = new ValidSudoku();
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		System.out.println(
				"Is the given board a valid sudoku board? " + ((obj.isValidSudoku(board) == true) ? "Yes" : "No"));
	}

}
