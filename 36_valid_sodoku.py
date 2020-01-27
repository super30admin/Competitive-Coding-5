from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        """
            // Time Complexity : O(mn)
                'm' is the noOfRows and 'n' is the noOfCols
            // Space Complexity : O(1)
            // Three line explanation of solution in plain english:
                - Check each row
                - Check each column
                - Check each sub box (block // 3 * 3, block % 3 * 3)
        """
        rows = len(board)
        if not board or rows < 9 or len(board[0]) < 9:
            return False
        cols = len(board[0])

        # check row range
        for row in range(rows):
            boolean = [False for _ in range(rows)]
            for col in range(cols):
                if board[row][col] != '.':
                    idx = int(board[row][col]) - 1
                    if boolean[idx]: return False
                    boolean[idx] = True

        # check col range
        for col in range(cols):
            boolean = [False for _ in range(cols)]
            for row in range(rows):
                if board[row][col] != '.':
                    idx = int(board[row][col]) - 1
                    if boolean[idx]: return False
                    boolean[idx] = True

        # check sub-boxes
        for block in range(rows):
            boolean = [False for _ in range(rows)]
            row_start = block // 3 * 3
            col_start = block % 3 * 3
            for row in range(row_start, row_start + 3):
                for col in range(col_start, col_start + 3):
                    if board[row][col] != '.':
                        idx = int(board[row][col]) - 1
                        if boolean[idx]: return False
                        boolean[idx] = True
        return True


if __name__ == '__main__':
    s = Solution()
    sudoku = [[".", ".", "4", ".", ".", ".", "6", "3", "."],
              [".", ".", ".", ".", ".", ".", ".", ".", "."],
              ["5", ".", ".", ".", ".", ".", ".", "9", "."],
              [".", ".", ".", "5", "6", ".", ".", ".", "."],
              ["4", ".", "3", ".", ".", ".", ".", ".", "1"],
              [".", ".", ".", "7", ".", ".", ".", ".", "."],
              [".", ".", ".", "5", ".", ".", ".", ".", "."],
              [".", ".", ".", ".", ".", ".", ".", ".", "."],
              [".", ".", ".", ".", ".", ".", ".", ".", "."]]
    print(s.isValidSudoku(sudoku))
