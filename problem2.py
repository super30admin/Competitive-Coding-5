#https://leetcode.com/problems/valid-sudoku/
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rowlist=dict()
        colist=dict()
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]!=".":
                    v= int(board[i][j])
                    
                    #row fill
                    if i not in rowlist:
                        rowlist[i]=[0]*10
                    if rowlist[i][v]>0:
                        
                        return False
                    else:
                        rowlist[i][v]=v
                
                    #col fill
                    if j not in colist:
                        colist[j]=[0]*10
                    if colist[j][v]>0:
                        
                        return False
                    else:
                        colist[j][v]=v
                        
        #Check the sub boxes
        for i in range(0,9,3):
            #First 3 column
            cur=[0]*10
            for j in range(0,3):
                
                v1,v2,v3=0,0,0
                if board[i][j]!=".":
                    v1=int(board[i][j])
                if board[i+1][j]!=".":    
                    v2=int(board[i+1][j])
                if board[i+2][j]!=".":
                    v3=int(board[i+2][j])
                if cur[v1]>0:
                    return False
                if cur[v2]>0:
                    return False
                if cur[v3]>0:
                    return False
                cur[v1]=v1
                cur[v2]=v2
                cur[v3]=v3
            #Mid 3 cols
            cur=[0]*10
            for j in range(3,6):
                
                v1,v2,v3=0,0,0
                if board[i][j]!=".":
                    v1=int(board[i][j])
                if board[i+1][j]!=".":    
                    v2=int(board[i+1][j])
                if board[i+2][j]!=".":
                    v3=int(board[i+2][j])
                if cur[v1]>0:
                    return False
                if cur[v2]>0:
                    return False
                if cur[v3]>0:
                    return False
                cur[v1]=v1
                cur[v2]=v2
                cur[v3]=v3
            #Last 3 cols
            cur=[0]*10
            for j in range(6,9):
                
                v1,v2,v3=0,0,0
                if board[i][j]!=".":
                    v1=int(board[i][j])
                if board[i+1][j]!=".":    
                    v2=int(board[i+1][j])
                if board[i+2][j]!=".":
                    v3=int(board[i+2][j])
                if cur[v1]>0:
                    return False
                if cur[v2]>0:
                    return False
                if cur[v3]>0:
                    return False
                cur[v1]=v1
                cur[v2]=v2
                cur[v3]=v3


        return True
        #Time O(n^2)
        #Space O(n^2)
