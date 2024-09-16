// Time Complexity : O(9x9) approx O(1) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: Make use of dictionary to keep track of repeating element in row, colums
// or block. If we find repeating element then return false. Else return true

class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        
        
        
        for i in range(len(board)):
            rows={}
            for j in range(len(board[0])):
                
                if(board[i][j]!="."):
                    
                    # row
                    if(board[i][j] not in rows):
                        rows[board[i][j]]=1
                    else:
                        return(False)
        
         
        for j in range(9):
            cols={}
            for i in range(9):
                
                if(board[i][j]!="."):
                    
                    # row
                    if(board[i][j] not in cols):
                        cols[board[i][j]]=1
                    else:
                        return(False)
        
        for block in range(9):
            b={}
            for i in range(block//3*3,block//3*3+3):
                for j in range(block%3*3,block%3*3+3):

                    if(board[i][j]!="."):

                        # row
                        if(board[i][j] not in b):
                            b[board[i][j]]=1
                        else:
                            return(False)
        return(True)
        
        