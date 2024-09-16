'''
Time Complexity -->
O((m*n)^2)

Space Compelxity -->
O(m*n) we are making use of hashmap but the it will be total elements present in the 2d array

'''

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i in range(9):
            for j in range(9):
                if board[i][j]!='.':
                    if(self.rowValid(board, i, j) and self.colValid(board, i, j)):
                        continue
                            
                    else:
                        return False
        
        
        for i in range(9):
            for j in range(9):
                if i%3==0 and j%3==0:
                    if self.boxValid(board, i, j):
                        continue
                    else:
                        return False
                    
        return True
    
    def rowValid(self, board, row, col):
        val = board[row][col]
        for j in range(9):
            if board[row][j]==val and j!=col:
                return False
        return True
            
            
    
    def colValid(self, board, row, col):
        val = board[row][col]
        for i in range(9):
            if board[i][col]==val and i!=row:
                return False
        return True
    
    def boxValid(self, board, row, col):
        #print(board)
        #print(row,end =' ')
        #print(col)
        dit = {}
        for i in range(row, row+3):
            for j in range(col, col+3):
                if board[i][j]!='.':
                    try:
                        dit[board[i][j]]+=1
                        if dit[board[i][j]]>1:
                            return False
                    except:
                        dit[board[i][j]]=1
        #print(dit)
        return True
                
        
        
        