
# leet code - Valid Sudoko - 36 - https://leetcode.com/problems/valid-sudoku/
# Time complexity - O(M2*N2)
# space Complexity - O(M*N)
# Approach - We have to check each row,column, square is valid or not while traversing through the matrix.

class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
       
        
        def is_valid_row(board):
            for row in board:
                if not is_valid(row):
                    return False
            return True
        
        def is_valid_column(board):
            for i in range(len(board)):
                k=[]
                for j in range(len(board)):
                    k.append(board[j][i])
                    if not is_valid(k):
                        return False
            return True
        
        def is_valid_square(board):
            for i in (0,3,6):
                for j in (0,3,6):
                    t=[ board[m][n] for m in range (i,i+3) for n in range (j,j+3)]
                    if not is_valid(t):
                        return False
            return True
        
        def is_valid(line):
            res=[]
            for num in line:
                if num!='.': 
                    res.append(num)
            return len(res)==len(set(res))
                    
        return is_valid_row(board) and is_valid_column(board) and is_valid_square(board)