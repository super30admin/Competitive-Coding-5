"""
Problem: 36. Valid Sudoku
Leetcode: https://leetcode.com/problems/valid-sudoku/
Time complexity : O(1) since all we do here is just one iteration over the board with 81 cells.
Space complexity : O(1), we store the fixed amount of numbers in each of row, col and box list
Did this code successfully run on Leetcode : Yes
"""


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if not board:
            return

        # check if row, col and subboxes contain the digits 1-9 without repetition
        return self.is_valid_row(board) and self.is_valid_col(board) and self.is_valid_box

    def is_valid_row(self, board):
        for row in board:
            if not self.is_valid_unit(row):
                return False
        return True

    def is_valid_col(self, board):
        for j in range(9):
            col = []
            for i in range(9):
                col.append(board[i][j])
            if not self.is_valid_unit(col):
                return False
        return True

    def is_valid_box(self, board):
        for i in (0, 3, 6):
            for j in (0, 3, 6):
                box = [board[x][y] for x in range(i, i + 3) for y in range(j, j + 3)]
                if not self.is_valid_unit(box):
                    return False
        return True

    def is_valid_unit(self, arrlist):
        # # create a valid list
        unit = [i for i in arrlist if i != '.']
        # check length of distinct numbers with that of total numbers in a list
        return len(set(unit)) == len(unit)