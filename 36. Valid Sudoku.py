"""
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
"""

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        """
		Run Time Complexity: O(1)
		Space Complexity: O(1)
		
		
		Check there are unique values in the row, col and as well as check there are unique vaues in a square.
		"""
        return(self.is_row(board) and self.is_col(board) and self.is_board(board))
    
    def is_row(self, board):
        for row in board:
            if not self.is_valid(row):
                return False
        return True
    
    def is_col(self, board):
        for col in zip(*board):
            if not self.is_valid(col):
                return False
        return True
            
    
    def is_board(self, board):
        for i in range(0, 7, 3):
            for j in range(0,7,3):
                square = [board[x][y] for x in range(i, i + 3) for y in range(j ,  j+ 3)]
                if not self.is_valid(square):
                    return False
        return True
                
    def is_valid(self, values):
        val = [ val for val in values if val !='.' ]
        return len(set(val)) == len(val)
        