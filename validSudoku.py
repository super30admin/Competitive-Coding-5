from typing import List

class Solution:
# TC: (m*n)(m+n) since m and n are constant, so TC: O(1)
# SC: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No

    def isValidSudoku(self, board: List[List[str]]) -> bool:
        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                if board[i][j] == ".":
                    continue
                # Check all left
                r = i
                c = j-1
                while c >= 0:
                    if board[i][j] == board[r][c]:
                        return False
                    c -= 1
                # Check all right
                r = i
                c = j+1
                while c < n:
                    if board[i][j] == board[r][c]:
                        return False
                    c += 1
                # check all top
                r = i-1
                c = j
                while r >= 0:
                    if board[i][j] == board[r][c]:
                        return False
                    r -= 1
                # check all bottom
                r = i+1
                c = j
                while r < m:
                    if board[i][j] == board[r][c]:
                        return False
                    r += 1
                # check the current 3*3 block
                lower_bound_column = (j//3)*3
                upper_bound_column = lower_bound_column + 3

                lower_bound_row = (i//3)*3
                upper_bound_row = lower_bound_row + 3

                for r in range(lower_bound_row, upper_bound_row):
                    for c in range(lower_bound_column,upper_bound_column):
                        if board[i][j] == board[r][c] and r != i and c != j:
                            return False


        return True