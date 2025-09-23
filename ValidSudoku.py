# Time Complexity : O(1)
# Space Complexity : O(1) both are O(1) because in sudoku we know that max grid can be only 9*9
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# The intuition here is to use 3 sets each for row, col and square(3*3) and then check if numbers are getting repeated.
# If yes, then return False or else return True

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rowSet = set()
        colSet = set()
        squareSet = set()

        for r in range(9):
            for c in range(9):
                if board[r][c] == '.':
                    continue
                num = board[r][c]
                if (r, num) in rowSet or (c, num) in colSet or ((r // 3, c // 3), num) in squareSet:
                    return False
                rowSet.add((r, num))
                colSet.add((c, num))
                squareSet.add(((r // 3, c // 3), num))