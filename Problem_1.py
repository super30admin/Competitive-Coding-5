"""
Problem : 1

Time Complexity : O(9^2)
Space Complexity : O(9^2)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Creating 3 hashsets each for rows, columns and 3*3 squares
iterating over the matrix and checking if the number has already appeared in the respective or column or
respective 3*3 grid, if not, adding the number to all of the hashsets at respective column, row and grid
and repeating this until found a number which is appreared before in the same row or column or grid,
and returning False or repeating until end of the matrix, and returning True as the matrix represents valid sudoku

"""

# Valid Sudoku

class Solution(object):
    def isValidSudoku(self, board):
        cols=collections.defaultdict(set)
        rows=collections.defaultdict(set)
        squares=collections.defaultdict(set)

        for r in range(9):
            for c in range(9):
                if board[r][c]==".":
                    continue
                if board[r][c] in rows[r] or board[r][c] in cols[c] or board[r][c] in squares[(r//3,c//3)]:
                    return False
                cols[c].add(board[r][c])
                rows[r].add(board[r][c])
                squares[(r//3,c//3)].add(board[r][c])
        print(rows)
        print(cols) 
        print(squares)
        return True