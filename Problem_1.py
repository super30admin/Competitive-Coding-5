# 36. Valid Sudoku


# Logic: Create a row and check if the len(row) and len(set(row)) are same or not. Same goes for column and grid as well.


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        return (self.rowCheck(board) and self.colCheck(board) and self.gridCheck(board))
    
    
    def gridCheck(self, board):
        for i in (0,3,6):
            for j in (0,3,6):
                word = [board[x][y] for x in range(i,i+3) for y in range(j, j+3)]
                if not self.helper(word):
                    return False
        return True
    
    def colCheck(self, board):
        for j in range(9):
            word = []
            for i in range(9):
                word.append(board[i][j])
            
            if not self.helper(word):
                return False
        return True
    
    def rowCheck(self, board):
        for row in board:
            if not self.helper(row):
                return False
        return True
    
    
    def helper(self, board):
        word = [i for i in board if i!='.']
        
        return len(word) == len(set(word))


# Time complexity: O(81) => O(1) => Since we know it is going to be 9x9 = 81 points at any given time.
# Space complexity: O(N) => I have created new array to pass into the helper functions 
# Accepted on Leetcode: Yes