# Time Complexity : O(1) as the board size is fixed 9x9
# Space Complexity : O(1) as the board size is fixed 9x9
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using 3 hashmaps to keep track of the numbers seen in each row, column and 3x3 sub-box.
# I am iterating through each cell in the board and checking if the number is already present
# in the corresponding row, column or sub-box. If it is, I return False. If not, I add the number to the corresponding
# row, column and sub-box. If I finish iterating through the board without finding any duplicates, I return True.

from typing import List
from collections import defaultdict
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row = defaultdict(set)
        col = defaultdict(set)
        sol = defaultdict(set)
        for i in range(9):
            for j in range(9):
                if board[i][j] == ".":
                    continue
                if board[i][j] in col[j] or board[i][j] in row[i] or board[i][j] in sol[(i//3,j//3)]:
                    return False
                row[i].add(board[i][j])
                col[j].add(board[i][j])
                sol[(i//3,j//3)].add(board[i][j])
        return True




        