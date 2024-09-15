// Time Complexity :O(m*n)
// Space Complexity : O(m+n+b) => O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.*;
import javafx.util.*;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {

		if (board == null || board.length == 0)
			return false;

		int m = board.length, n = board[0].length;

		Map<Integer, HashSet<Integer>> row = new HashMap<>();
		Map<Integer, HashSet<Integer>> col = new HashMap<>();
		Map<Pair<Integer, Integer>, HashSet<Integer>> box = new HashMap<>();
		HashSet<Integer> rowHS;
		HashSet<Integer> colHS;
		HashSet<Integer> boxHS;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
			
				if (board[i][j] != '.') {
					int val = board[i][j] - '0';
					// Row
					if (row.containsKey(i)) {
						rowHS = row.get(i);
						if (rowHS.contains(val)) {
							return false;
						}

					} else {
						rowHS = new HashSet<>();

					}
					
					rowHS.add(val);
					row.put(i, rowHS);
					
					//Column
					if(col.containsKey(j)) {
						colHS = col.get(j);
						if (colHS.contains(val)) {
							return false;
						}
					
					}else {
						 colHS = new HashSet<>();
					}
					
					colHS.add(val);
					col.put(j, colHS);
				
					
					// Box
					int boxRow = i / 3;
					int boxCol = j / 3;

					Pair<Integer, Integer> key = new Pair<>( boxRow, boxCol );
					
					if(box.containsKey(key)) {
						boxHS = box.get(key);
						if(boxHS.contains(val)) {
							return false;
						}
					}else {
						boxHS = new HashSet<>();
					}

					boxHS.add(val);
					box.put(key, boxHS);

				}
			}
		}

		return true;

	}

	public static void main(String[] args) {

		char[][] board = { { '5', '3', '.', '.', '5', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		
		char[][] board1 = {{'.','.','.','.','5','.','.','1','.'},
						   {'.','4','.','3','.','.','.','.','.'},
						   {'.','.','.','.','.','3','.','.','1'},
						   {'8','.','.','.','.','.','.','2','.'},
						   {'.','.','2','.','7','.','.','.','.'},
						   {'.','1','5','.','.','.','.','.','.'},
						   {'.','.','.','.','.','2','.','.','.'},
						   {'.','2','.','9','.','.','.','.','.'},
						   {'.','.','4','.','.','.','.','.','.'}};

		
		char[][] board2 = {{'.','.','.','.','5','.','.','1','.'},
							{'.','4','.','3','.','.','.','.','.'},
							{'.','.','.','.','.','3','.','.','1'},
							{'8','.','.','.','.','.','.','2','.'},
							{'.','.','2','.','7','.','.','.','.'},
							{'.','1','5','.','.','.','.','.','.'},
							{'.','.','.','.','.','2','.','.','.'},
							{'.','2','.','9','.','.','.','.','.'},
							{'.','.','4','.','.','.','.','.','.'}};

		ValidSudoku v = new ValidSudoku();
		boolean res = v.isValidSudoku(board);
		System.out.println(res);

	}

}
