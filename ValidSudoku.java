// Time Complexity : O(1) Fixed Time
// Space Complexity : O(1) Fixed Space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashSet;

public class ValidSudoku {
	class Solution {
		public boolean isValidSudoku(char[][] board) {
			if (board == null || board.length == 0)
				return false;
			HashSet<String> seen = new HashSet<>();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					char currentValue = board[i][j];
					if (currentValue != '.') {
						boolean rowDuplicate = seen.add(currentValue + "found in row" + i);
						boolean columnDuplicate = seen.add(currentValue + "found in column" + j);
						boolean subGridDuplicate = seen.add(currentValue + "found in sub grid" + i / 3 + "-" + j / 3);
						if (!rowDuplicate || !columnDuplicate || !subGridDuplicate)
							return false;
					}
				}
			}
			return true;
		}
	}
}
