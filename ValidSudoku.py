"""
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells 
need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the 
digits 1-9 without repetition.

Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

 
"""
# Time Complexity : O(n^2) (technically O(1) since board dimentions are fixed)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from typing import List
from collections import deque

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:

        # since sudoku is 9*9
        n = 9 

        row = [set() for _ in range n]
        col = [set() for _ in range n]
        block = [set() for _ in range n]

        for r in range(n):
            for c in range(n):

                value = board[r][c]

                # check if value is integer
                if val == ".":
                    continue

                # for row
                if val in row[r]:
                    return False
                else:
                    row[r].add(val)

                # for column
                if val in col[c]:
                    return False
                else:
                    col[c].add(val)

                # for small block of 3*3, using this formula to get index in each block
                index = (r // 3) * 3 + (c // 3)
                if val in block[index]:
                    return False
                else:
                    block[index].add(val)

        return True


        
        

