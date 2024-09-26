---------------------------------- Valid Sudoku -------------------------------------
# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I have used 2 dictionaries which stores the rows values , column values and as well as 3x3 boxes values.
# Iterating through the matrix, I will check if the element is not '.', Id yes, I will check if the element already exists in the row,
#of that column or in that box. If yes, return False, else append the element into that row, col or boxes.


from collections import defaultdict
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if not board:
            return True
        
        row = defaultdict(set)
        col = defaultdict(set)
        box = defaultdict(set)
        
        m = len(board)
        n = len(board[0])
        
        for i in range(m):
            for j in range(n):
                if board[i][j] != '.':
                    if board[i][j] in row[i] or board[i][j] in col[j] or board[i][j] in box[(i//3, j//3)]:
                        return False
                    else:
                        row[i].add(board[i][j])
                        col[j].add(board[i][j])
                        box[(i//3, j//3)].add(board[i][j])
        return True