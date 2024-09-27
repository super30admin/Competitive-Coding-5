from collections import defaultdict
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        # Check every row
        for i in range(len(board)):
            d = defaultdict(int)
            for j in range(len(board[0])):
                if board[i][j] != '.':
                    d[board[i][j]] += 1
                    if d[board[i][j]] > 1:
                        return False
                         
        # Check every column
        for i in range(0, 9):
            d = defaultdict(int)
            for j in range(0, 9):
                if board[j][i] != '.':
                    d[board[j][i]] += 1
                    if d[board[j][i]] > 1:
                        return False
                    
        # Check every 3*3 sub-matrix
        b = 0
        while b < 9:
            
            d = defaultdict(int)
            rowStart = (b // 3) * 3
            rowEnd = (b // 3) * 3 + 3
            colStart = (b % 3) * 3
            colEnd = (b % 3) * 3 + 3
            for i in range(rowStart, rowEnd):
                for j in range(colStart, colEnd):
                    if board[i][j] != '.':
                        d[board[i][j]] += 1
                        if d[board[i][j]] > 1:
                            return False
            b += 1   
        
        return True
