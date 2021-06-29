class Solution:
    """Time complexity-O(3*n^2)~=O(n^2)
    Space Complexity-O(n^2)"""
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        isvalidRowCol=False
        notinBox=False
        k=0
        for i in  range(len(board)):
            if self.isValidRow(board, i)==False or self.isValidCol(board, i)==False:
                return False
        while k<len(board):
            l=0
            while l<len(board[0]):
                if self.notinBox(board, k,l)==True:
                    return False
                l+=3
            k+=3  
        return True
    
    def notinBox(self, board, i, j):
        # print(board[i][j],i,i+3,j,j+3)
        mapfunc=dict()
        for k in range(i,i+3):
            for l in range(j,j+3):
                if board[k][l]==".":
                    continue
                if board[k][l] not in mapfunc:
                    mapfunc[board[k][l]]=True
                else:
                    return True

    def isValidRow(self, board, i):
        mapfunc=dict()
        for j in range(len(board[0])):
            if board[i][j]==".":
                continue
            if board[i][j] not in mapfunc:
                mapfunc[board[i][j]]=True
            else:
                return False
        return True
    
    def isValidCol(self, board, i):
        mapfunc=dict()
        for j in range(len(board[0])):
            if board[j][i]==".":
                continue
            if board[j][i] not in mapfunc:
                mapfunc[board[j][i]]=True
            else:
                return False
        return True
            
                
                
        