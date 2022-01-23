# Link: https://leetcode.com/problems/valid-sudoku/
# // Time Complexity : O(nm) where n  and m is the size of the matrix. 
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes.
# // Any problem you faced while coding this : No.

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        l = len(board)
        row = [[None for i in range(l)] for j in range(l)]
        column = [[None for i in range(l)] for j in range(l)]
        submatrix = [[None for i in range(l)] for j in range(l)]
        
        for i in range(l):
            for j in range(l):
                if board[i][j] == ".":
                    continue
                pos = int(board[i][j]) - 1
                
                if row[i][pos] == True:
                    return False
                row[i][pos] = True
                
                if column[j][pos] == True:
                    return False
                column[j][pos] = True
                
                submatrix_row = (i //3) * 3 + j // 3
                if submatrix[submatrix_row][pos] == True:
                    return False
                submatrix[submatrix_row][pos] = True
        return True
