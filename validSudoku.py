# Time Complexity: O(mn)
# Space Complexity: O(1)
class Solution:
    def validBlock(self, row, col, board):
        #   maintain a dictionary to check the presence of digits
        d = {}
        
        # Iterate through a 3X3 block
        # If it is a '.', continue
        # Check if the element is repeated by checking the dictionary
        # Check if the element is less than 1 or greater than 9
        # If the element does not exist anywhere, place it in the dictionary with freq 1
        for r in range(row, row + 3):
            for c in range(col, col + 3):
                if board[r][c] == '.':
                    continue
                
                elif board[r][c] in d or int(board[r][c]) < 1 or int(board[r][c]) > 9:
                    return False
                
                else:
                    d[board[r][c]] = 1
        return True
    
    def validRow(self, r, board):
        #   maintain a dictionary to check the presence of digits
        d = {}
        
        # In the same row, iterate through all the columns
        # If it is a '.', continue
        # Check if the element is repeated by checking the dictionary
        # Check if the element is less than 1 or greater than 9
        # If the element does not exist anywhere, place it in the dictionary with freq 1
        for c in range(9):
            if board[r][c] == '.':
                continue

            elif board[r][c] in d or int(board[r][c]) < 1 or int(board[r][c]) > 9:
                return False

            else:
                d[board[r][c]] = 1
        return True
    
    def validCol(self, c, board):
        #   maintain a dictionary to check the presence of digits
        d = {}
        
        # In the same column, iterate through all the rows
         # If it is a '.', continue
        # Check if the element is repeated by checking the dictionary
        # Check if the element is less than 1 or greater than 9
        # If the element does not exist anywhere, place it in the dictionary with freq 1
        for r in range(9):
            if board[r][c] == '.':
                continue

            elif board[r][c] in d or int(board[r][c]) < 1 or int(board[r][c]) > 9:
                return False

            else:
                d[board[r][c]] = 1
        return True
        
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # To check if it is a valid 3X3 block
        for row in range (0, 9, 3):
            for col in range(0, 9, 3):
                if not self.validBlock(row, col, board):
                    return False
                
        # To check if the row is valid
        for row in range(9):
            if not self.validRow(row, board):
                return False
        
         # To check if the col is valid
        for col in range(9):
            if not self.validCol(col, board):
                return False
            
        return True
                