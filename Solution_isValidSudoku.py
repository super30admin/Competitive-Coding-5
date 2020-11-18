"""
Time complexity is 0(M)  to create a boolean list with False 
Space complexity is 0(M)  for the boolean list 

"""
class Solution_isValidSudoku:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if board is None or len(board)==0 or len(board[0])==0:
            return False
        
        m=len(board)
        n=len(board[0])
        #checking row 
        for i in range(m):
            b=[False]*m
            for j in range(n):
                if(board[i][j]!="."):
                    idx=int(board[i][j])-1
                    if(b[idx]):
                        return False
                    b[idx]=True
         #checking column
        for j in range(n):
            b=[False]*m
            for i in range(m):
                if(board[i][j]!="."):
                    idx=int(board[i][j])-1
                    if(b[idx]):
                        return False
                    b[idx]=True
        
        #checking sub-block 
        for block in range(0,m):
            b=[False]*m
            for i in range(block//3*3,block//3*3+3):
                for j in range(block%3*3,block%3*3+3):
                    if(board[i][j]!="."):
                        idx=int(board[i][j])-1
                        if(b[idx]):
                            return False
                        b[idx]=True
        return True
                    
                
                
            
        