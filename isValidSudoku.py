#36. Valid Sudoku
# Time Complexity : O(m*n)
# Space Complexity :O(1) as range of rows/col/box will be 0-9
# Did this code successfully run on Leetcode : Yes
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        rows = [set() for i in range(9)]
        cols = [set() for i in range(9)]
        boxes = [set() for i in range(9)]
        for i in range(9):
            for j in range (9):
                box = (i // 3) * 3 + j // 3
                if board[i][j] == ".":
                    continue
                if board[i][j] in rows[i]:
                    return False
                if board[i][j] in cols[j]:
                    return False
                if board[i][j] in boxes[box]:
                    return False
                rows[i].add(board[i][j])
                cols[j].add(board[i][j])
                boxes[box].add(board[i][j])
        return True