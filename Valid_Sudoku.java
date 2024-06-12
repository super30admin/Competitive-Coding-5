
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No
import java.util.*;

public class Valid_Sudoku {
	public boolean isValidRow(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashSet<Character> rowSet = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (rowSet.contains(board[i][j]))
					return false;
				if (board[i][j] != '.')
					rowSet.add(board[i][j]);
			}
		}
		return true;
	}

	public boolean isValidCol(char[][] board) {
		for (int j = 0; j < 9; j++) {
			HashSet<Character> colSet = new HashSet<>();
			for (int i = 0; i < 9; i++) {
				if (colSet.contains(board[i][j]))
					return false;
				if (board[i][j] != '.')
					colSet.add(board[i][j]);
			}
		}
		return true;
	}

	public boolean isValidBox(char[][] board, int i, int j) {
		HashSet<Character> box = new HashSet<>();
		for (int r = i; r < i + 3; r++) {
			for (int c = j; c < j + 3; c++) {
				if (box.contains(board[r][c]))
					return false;
				if (board[r][c] != '.')
					box.add(board[r][c]);
			}
		}
		return true;
	}

	public boolean isValidSudoku(char[][] board) {
		if (!isValidRow(board))
			return false;
		if (!isValidCol(board))
			return false;
		for (int i = 0; i < 9; i = i + 3) {
			for (int j = 0; j < 9; j = j + 3) {
				if (!isValidBox(board, i, j))
					return false;
			}
		}
		return true;
	}
}