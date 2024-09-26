# Time complexity: O(n * n) but we know n is 9 (constant). So O(1).
# Space complexity: O(n) but we know n is 9 (constant). So O(1).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if len(board) == 0: return false
        for i in range(9):
            h_rows, h_cols = set(), set()       # HashSet for unique numbers in rows and columns
            for j in range(9):
                if board[i][j] != '.':          # Checking along a row.
                    if board[i][j] in h_cols:
                        return False
                    h_cols.add(board[i][j])
                if board[j][i] != '.':          # Checking along a cloumn.
                    if board[j][i] in h_rows:
                        return False
                    h_rows.add(board[j][i])
        # Checking the subgrid.
        for i in range(0, 9, 3):
            for j in range(0, 9, 3):
                h_grid = set()
                for k in range(3):
                    for l in range(3):
                        if board[i + k][j + l] != '.':
                            if board[i + k][j + l] in h_grid:
                                return False
                            h_grid.add(board[i + k][j + l])
        return True
            
            