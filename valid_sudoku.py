# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for row in range(9):
            check = set()
            for col in range(9):
                cell = board[row][col]
                if not self.isValid_cell(cell, check):
                    return False
        
        for col in range(9):
            check = set()
            for row in range(9):
                cell = board[row][col]
                if not self.isValid_cell(cell, check):
                    return False

        for row_start in range(0, 9, 3):
            for col_start in range(0, 9, 3):
                check = set()
                row_stop = row_start + 3
                col_stop = col_start + 3
                for row in range(row_start, row_stop):
                    for col in range(col_start, col_stop):
                        cell = board[row][col]
                        if not self.isValid_cell(cell, check):
                            return False
        
        return True
        
    def isValid_cell(self, cell, check):
        if cell != '.':
            if cell in check:
                return False
            else:
                check.add(cell)
        return True
        