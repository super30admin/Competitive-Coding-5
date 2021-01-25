import java.util.HashSet;

/*
 * The complexity of the algorithm is O(9) where 9 is constant.
 * 
 */


public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {

		if (board == null || board.length == 0)
			return false;

		for (int i = 0; i < 9; i++) {

			HashSet<Integer> row = new HashSet<>();
			for (int j = 0; j < 9; j++) {

				if ((board[i][j] != '.')) {

					if (!row.contains(board[i][j] - '0')) {
						row.add((int) (board[i][j] - '0'));
					} else {
						return false;
					}
				}

			}

		}

		for (int j = 0; j < 9; j++) {

			HashSet<Integer> col = new HashSet<>();

			for (int i = 0; i < 9; i++) {

				if ((board[i][j] != '.')) {

					if (!col.contains(board[i][j] - '0')) {
						col.add((int) (board[i][j] - '0'));
					} else {
						return false;
					}
				}

			}

		}

		for (int block = 0; block < 9; block++) {
			HashSet<Integer> grid = new HashSet<>();

			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {

				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {

					if ((board[i][j] != '.')) {

						if (!grid.contains(board[i][j] - '0')) {
							grid.add((int) (board[i][j] - '0'));
						} else {
							return false;
						}
					}

				}

			}

		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
