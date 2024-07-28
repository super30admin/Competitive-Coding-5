#Time complexity --> o(mn)
#space complexity --> o(1)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
1)we start traversing each and every element in the matrix.
2)we maintain three dictionaries to track the elements in each row,column and each box.
3)No element in each of these row,column and box should appear twice.If yes then we return false,else we return True.

class Solution:
    def validbox(self,board,row,col):
        boxdict={}
        for i in range(row,row+3):
            for j in range(col,col+3):
                val=board[i][j]
                if val=='.':
                    continue
                elif val not in boxdict:
                    boxdict[val]=1
                else:
                    return False
        return True
    
    def rowcheck(self,board,row):
        rowdict={}
        for i in range(9):
            if board[row][i]=='.':
                continue
            elif board[row][i] not in rowdict:
                rowdict[board[row][i]]=1
            else:
                return False
        return True
        
        
    
    def colcheck(self,board,col):
        coldict={}
        for i in range(9):
            if board[i][col]=='.':
                continue
            elif board[i][col] not in coldict:
                coldict[board[i][col]]=1
            else:
                return False
        return True
        
        
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if board==None or len(board)==0:
            return True
        # box check
        for row in range(0,9,3):
            for col in range(0,9,3):
                if self.validbox(board,row,col)==False:
                    return False
        # row check
        for row1 in range(9):
            if self.rowcheck(board,row1)==False:
                return False
            
        # col check
        
        for col1 in range(9):
            if self.colcheck(board,col1)==False:
                return False
        
        return True