import java.util.HashSet;
import java.util.Set;

// Time Complexity : O(N^2) N = 9
// Space Complexity : O(N^2) N = 9
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Iterate on each row and check if any number is repeating. If so return false.
 * Similarly, iterate on each column and check if any number is repeating. If
 * so, return false. For 3X3 box, iterate over each row and column but increment
 * them by 3 so that every iteration we pick one 3X3 matrix and check if it has
 * any repeating numbers.
 *
 */
class Solution {
	public boolean isValidSudoku(char[][] board) {
		// Rows
		for (int i = 0; i < 9; i++) {
			Set<Character> rowSet = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (rowSet.contains(board[i][j]))
					return false;
				else if (board[i][j] == '.')
					continue;
				else
					rowSet.add(board[i][j]);
			}
		}
		// Columns
		for (int i = 0; i < 9; i++) {
			Set<Character> colSet = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (colSet.contains(board[j][i]))
					return false;
				else if (board[j][i] == '.')
					continue;
				else
					colSet.add(board[j][i]);
			}
		}
		// boxes
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				if (!checkBox(board, i, j))
					return false;
			}
		}
		return true;
	}

	public boolean checkBox(char[][] board, int idxI, int idxJ) {
		int rows = idxI + 3;
		int cols = idxJ + 3;
		Set<Character> boxSet = new HashSet<>();
		for (int i = idxI; i < rows; i++) {
			for (int j = idxJ; j < cols; j++) {
				if (boxSet.contains(board[i][j]))
					return false;
				else if (board[i][j] == '.')
					continue;
				else
					boxSet.add(board[i][j]);
			}
		}
		return true;
	}
}