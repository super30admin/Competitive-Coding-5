""""// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row = [set() for _ in range(9)]
        column = [set() for _ in range(9)]
        matrix = {(0, 0): set(), (0, 1): set(), (0, 2): set(), (1, 0): set(), (1, 1): set(), (1, 2): set(),
                  (2, 0): set(), (2, 1): set(), (2, 2): set()}

        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    continue
                if board[i][j] in row[i]:
                    return False
                row[i].add(board[i][j])
                if board[i][j] in column[j]:
                    return False
                column[j].add(board[i][j])

                if board[i][j] in matrix[(i // 3, j // 3)]:
                    return False
                matrix[(i // 3, j // 3)].add(board[i][j])
        return True
