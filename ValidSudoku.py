'''
    Time Complexity:
        O(1) (because we only have to visit 81 cells)

    Space Complexity:
        O(1) (because the combinations of values in all of the sets is defined)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Maintain 3 sets:
            -> one for keeping track of row values
            -> one for keeping track of column values
            -> one for keeping track of the values in the current 3x3 box.

        Visit each cell, if the cell is not empty,
            -> check if the value at this cell is anywhere in the row, column or box.
'''

EMPTY = '.'

class Solution(object):
    def __init__(self):
        self.row_set = set()
        self.col_set = set()
        self.box_set = set()

    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """

        for i, row in enumerate(board):
            for j, cell in enumerate(row):
                if cell == EMPTY:
                    continue

                if not self.valid(i, j, cell):
                    return False

        return True

    def valid(self, i, j, val):
        row_key, col_key, box_key = self.build_keys(i, j, val)

        if row_key in self.row_set:
            return False

        if col_key in self.col_set:
            return False

        if box_key in self.box_set:
            return False

        self.row_set.add(row_key)
        self.col_set.add(col_key)
        self.box_set.add(box_key)
        return True

    def build_keys(self, i, j, val):
        row_key = (i, val)
        col_key = (j, val)
        box_key = (i//3, j//3, val)

        return row_key, col_key, box_key
