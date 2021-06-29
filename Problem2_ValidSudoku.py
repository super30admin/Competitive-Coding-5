'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 36. Valid Sudoku

# Determine if a 9 x 9 Sudoku board is valid. Only the filled cells 
# need to be validated according to the following rules:

#     Each row must contain the digits 1-9 without repetition.
#     Each column must contain the digits 1-9 without repetition.
#     Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 
#     without repetition.
    
# Note:
# A Sudoku board (partially filled) could be valid but is not necessarily solvable.
# Only the filled cells need to be validated according to the mentioned rules.



#-----------------
# Time Complexity: 
#-----------------
# O(N X N) - Where N is the number of rows = number of columns
#          - Since N is constant = 9, it can be considered O(1)
#------------------
# Space Complexity: 
#------------------
# O(N): Need to store N elements along the row or column. 
#       N is constant = 9, it can be considered O(1)


#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if len(board) % 3 != 0 or len(board[0]) % 3 != 0:
            return False
        
        digit_set = set()

        for i in range(9):
            for j in range(9):
                if not self.isValidSudokuHelper(board, i, j):
                    return False
        
        return True
        
    def isValidSudokuHelper(self, board:List[List[str]], row:int, col:int) -> bool:
        grid_start_row = row - (row % 3)
        grid_start_col = col - (col % 3)
        return self.check_row(board, row) and self.check_col(board, col) and self.check_grid(board, grid_start_row, grid_start_col)
    
    def check_row(self, board:List[List[str]], row:int) -> bool:
        nums_set = set()
        for i in range(9):
            if board[row][i] in nums_set:
                return False
            
            if board[row][i] != ".":
                nums_set.add(board[row][i])
        
        return True
    
    def check_col(self, board:List[List[str]], col:int) -> bool:
        nums_set = set()
        for i in range(9):
            if board[i][col] in nums_set:
                return False
            
            if board[i][col] != ".":
                nums_set.add(board[i][col])
        
        return True
    
    def check_grid(self, board:List[List[str]], start_row:int, start_col:int) -> bool:
        nums_set = set()
        for row in range(3):
            for col in range(3):
                curr = board[start_row + row][start_col + col]
                if curr in nums_set:
                    return False
                
                if curr != ".":
                    nums_set.add(curr)
        
        return True