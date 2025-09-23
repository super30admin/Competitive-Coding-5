'''
Time: O(N^2) - where N = row = col
Space: O(9) = O(1).  
'''
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        #each row
        for i in range(len(board)):
            check=[False]*9
            for j in range(len(board[0])):
                if board[i][j]!=".":
                    if check[(int)(board[i][j])-1]==True:
                        return False
                    else:
                        check[(int)(board[i][j])-1]=True

        #each column
        for i in range(len(board)):
            check=[False]*9
            for j in range(len(board[0])):
                if board[j][i]!=".":
                    if check[(int)(board[j][i])-1]==True:
                        return False
                    else:
                        check[(int)(board[j][i])-1]=True
        
        #each 3x3 cell
        for k in range(9):
            check=[False]*9
            sr=(k//3)*3 #0,0,0,3,3,3,6,6,6
            sc=(k%3)*3 #0,3,6,0,3,6,0,3,6
            for i in range(3):
                r=sr+i
                for j in range(3):
                    c=sc+j
                    if board[r][c]!=".":
                        if check[(int)(board[r][c])-1]==True:
                            return False
                        else:
                            check[(int)(board[r][c])-1]=True
        return True
                    