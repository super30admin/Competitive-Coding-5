# time complexity is o(mn), where m and n is the number of rows and columns in a sudoku board
# space complexity is o(max(m,n)), where m and n is the number of rows and columns in a sudoku board
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        r = len(board)
        c = len(board[0])
        for i in range(r):
            rowcheck = [False for k in range(r)]
            for j in range(c):
                if(board[i][j] != '.'):
                    if(rowcheck[int(board[i][j]) - 1]):
                        return False
                    else:
                        rowcheck[int(board[i][j]) - 1] = True
                        
        for j in range(c):
            colcheck = [False for k in range(r)]
            for i in range(r):
                if(board[i][j] != '.'):
                    if(colcheck[int(board[i][j]) - 1]):
                        return False
                    else:
                        colcheck[int(board[i][j]) - 1] = True
                        
        for b in range(r):
            scheck = [False for k in range(r)]
            for i in range((b//3)*3, (b//3)*3 + 3):
                for j in range((b%3)*3, (b%3)*3 + 3):
                    if(board[i][j] != '.'):
                        if(scheck[int(board[i][j]) - 1]):
                            return False
                        else:
                            scheck[int(board[i][j]) - 1] = True
        return True
                    
                
                        
        
        