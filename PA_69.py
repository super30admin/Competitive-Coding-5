#LC 36 - Valid Sudoku
#Time Complexity - O(m*n)
#Space Complexity - O(m*n)
from collections import defaultdict
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        if not board:
            return True
        def getrow(board,row):
            ans = []
            for i in range(len(board[0])):
                ans.append(str(board[row][i]))
            return ans
        
        def getcol(board,col):
            ans = []
            for i in range(len(board)):
                ans.append(str(board[i][col]))
            return ans
        
        def isvalidrow(row):
            d = defaultdict(int)
            for i in row:
                if d[i] == 1 and i != ".":
                        return False
                elif i != ".":
                    d[i] = 1
            #print(d)
            return True
        
        def isvalidcol(col):
            #print("OLL")
            d = defaultdict(int)
            for i in col:
                if d[i] == 1 and i.isdigit():
                        return False
                elif i.isdigit():
                    d[i] = 1
            return True
        
        def checkrow(board):
            for i in range(len(board)):
                if not isvalidrow(getrow(board,i)):
                    return False
            return True
        
        def checkcol(board):
            for i in range(len(board[0])):
                if not isvalidcol(getcol(board,i)):
                    return False
            return True
        #return checkcol(board)
        
        def getsquare(board,row,col):
            #print(row,col)
            ans = []
            for i in range(3):
                ans.append([0]*3)
            x,y = 0,0
            for i in range(row,row+3):
                y = 0
                for j in range(col,col+3):
                    ans[x][y] = board[i][j]
                    y = y + 1
                x = x + 1
            return ans
        
        def validsquare(board):
            d = defaultdict(int)
            for i in range(len(board)):
                for j in range(len(board[0])):
                    if d[board[i][j]] == 1 and board[i][j].isdigit():
                        return False
                    elif board[i][j].isdigit():
                        d[board[i][j]] = 1
            return True
        
        def square(board):
            i,j,k = 0,0,0
            rows = len(board)
            cols = len(board[0])
            while i <= rows - 3:
                j = 0
                while j <= cols - 3:
                    if not validsquare(getsquare(board,k,j)):
                        return False
                    j = j + 3
                k = k + 3
                i = i + 3
            return True
        return square(board) and checkcol(board) and checkrow(board)