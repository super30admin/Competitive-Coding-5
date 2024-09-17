'''
Time Complexity : 0(n*n)
Space Complexity : 0(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
- A valid sudoku for this question have this rule
 - Each row must contain the digits 1-9 without repetition.
 - Each column must contain the digits 1-9 without repetition
 - Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

- Add a check for individual rows, individual columns, and each subgrid
'''


class Solution:
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        row,col = len(board),len(board[0])
        
        valid = True
        #row check
        
        for i in range(row):
            d={}
            for j in range(col):
                
                if board[i][j]==".":
                    pass
                elif board[i][j]<"1" or board[i][j]>"9":
                    valid=False
                    return valid
                elif board[i][j] in d.keys():
                    valid = False
                    return valid
                else:
                    d[board[i][j]]=1
        
       
        #coloumn check
        for i in range(row):
            d={}
            for j in range(col):
                
                if board[j][i]==".":
                    pass
                elif board[j][i]<"1" or board[j][i]>"9":
                    valid=False
                    return valid
                elif board[j][i] in d.keys():
                    valid = False
                    return valid
                else:
                    d[board[j][i]] = 1
        
        
        
        #sub grids check
        for i in range(3):
            for j in range(3):
                row,col = i*3,j*3
                d={}
                for k in range(row,row+3):
                    for h in range(col,col+3):
                        
                        if board[k][h]==".":
                            pass
                        elif board[k][h]<"1" or board[k][h]>"9":
                            valid=False
                            return valid
                        elif board[k][h] in d.keys():
                            valid = False
                            return valid
                        else:
                            d[board[k][h]] = 1
        return valid