'''
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
'''

# // Time Complexity : O(m*n)
# // Space Complexity : O(m*n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # lets create an array of empty hashsets for each row, column and block
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        blocks = [set() for _ in range(9)]

        # lets check each element
        for row in range(9):
            for col in range(9):
                if board[row][col] == '.':
                    continue

                # if value is already in row/col/box set, return false, else add
                # row
                if board[row][col] in rows[row]:
                    return False
                rows[row].add(board[row][col])

                # col
                if board[row][col] in cols[col]:
                    return False
                cols[col].add(board[row][col])

                # block
                block_index = (row//3)*3 + (col//3)
                if board[row][col] in blocks[block_index]:
                    return False
                blocks[block_index].add(board[row][col])
        
        return True
