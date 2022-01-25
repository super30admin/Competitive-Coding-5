# Time Complexity : O(n^2)
# Space Complexity : O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : yes

import collections
from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = collections.defaultdict(set)
        cols = collections.defaultdict(set)
        blocks = collections.defaultdict(set)

        for r in range(9):
            for c in range(9):
                # continue if there is no element
                if board[r][c] == ".":
                    continue
                # checking if the elements exist in either rows or cols, or in the blocks
                if(board[r][c] in rows[r]) or (board[r][c] in cols[c]) or (board[r][c] in blocks[(r // 3, c // 3)]):
                    return False
                # otherwise condition
                rows[r].add(board[r][c])
                cols[c].add(board[r][c])
                blocks[(r // 3, c // 3)].add(board[r][c])

        return True
