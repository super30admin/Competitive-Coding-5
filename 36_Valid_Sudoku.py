# Leetcode problem link : https://leetcode.com/problems/valid-sudoku/
# Time Complexity:    O(n*m)
# Space Complexity:   O(n*m)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
    1. Traverse through the matrix
    2. Maintain a hashset for each column,each row and each block

'''

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row_set = [set() for _ in range(9)]
        col_set = [set() for _ in range(9)]
        block_set = [[set() for _ in range(3)] for _ in range(3)]
        
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    continue
                if board[i][j] in row_set[i] or board[i][j] in col_set[j] or board[i][j] in block_set[i//3][j//3]:
                    return False
                row_set[i].add(board[i][j])
                col_set[j].add(board[i][j])
                block_set[i//3][j//3].add(board[i][j])
        
        return True