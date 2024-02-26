'''
TC: O(n^2) since we need to go through every cell in the board 
        - and sudoku is always a square matrix
SC: O(n) - where in worst case if all the cells are filled 
        - we need to store all values in rows,cols and grid hashmaps
        - but it can be interpreted as O(1) since n is fixed 9X9 matrix.
'''
import collections
from typing import List

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        ROWS, COLS = len(board), len(board[0])
        rows = collections.defaultdict(set)
        cols = collections.defaultdict(set)
        grid = collections.defaultdict(set)
        
        for k in range(0,9):
            for i in range(COLS):
                if board[k][i] == '.':
                        continue
                if board[k][i] in rows[k]:
                    return False
                rows[k].add(board[k][i])
        for k in range(0,9):
            for i in range(ROWS):
                if board[i][k] == '.':
                        continue
                if board[i][k] in cols[k]:
                    return False
                cols[k].add(board[i][k])
        for i in range(ROWS):
            for j in range(COLS):
                if board[i][j] == '.':
                    continue
                if board[i][j] in grid[3*(i//3)+(j//3)]:
                    return False
                grid[3*(i//3)+(j//3)].add(board[i][j])
        return True
s=Solution()
print(s.isValidSudoku([["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]))
print(s.isValidSudoku([["8","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]))
print(s.isValidSudoku([[".",".","4",".",".",".","6","3","."],[".",".",".",".",".",".",".",".","."],["5",".",".",".",".",".",".","9","."],[".",".",".","5","6",".",".",".","."],["4",".","3",".",".",".",".",".","1"],[".",".",".","7",".",".",".",".","."],[".",".",".","5",".",".",".",".","."],[".",".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".",".","."]]))
print(s.isValidSudoku([[".",".",".",".","5",".",".","1","."],[".","4",".","3",".",".",".",".","."],[".",".",".",".",".","3",".",".","1"],["8",".",".",".",".",".",".","2","."],[".",".","2",".","7",".",".",".","."],[".","1","5",".",".",".",".",".","."],[".",".",".",".",".","2",".",".","."],[".","2",".","9",".",".",".",".","."],[".",".","4",".",".",".",".",".","."]]))