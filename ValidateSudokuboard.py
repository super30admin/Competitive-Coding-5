# Time Complexity : O(mxn)
# Space Complexity : O(mxn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to create a check every row and colum separately then find in the 9 sub matrix using set to check if unique items are present.

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        m=len(board)
        n=len(board[0])
        subboard=[[0,0],[0,3],[0,6],[3,0],[3,3],[3,6],[6,0],[6,3],[6,6]]
        
        for i in range(0,m):
            v=set()
            for j in range(0,n):
                if board[i][j] != ".":
                    if board[i][j] not in v:
                        v.add(board[i][j])
                    else:
                        return False
        for j in range(0,n):
            v=set()
            for i in range(0,m):

                if board[i][j] != ".":
                    
                    if board[i][j] not in v:
                        v.add(board[i][j])
                    else:
                        return False
        
        for sub in subboard:
            i=sub[0]
            
            v=set()
            for i in range(i,i+3):
                j=sub[1]
                for j in range(j,j+3):
                    print(i,j)
                    if board[i][j] != ".":
                        if board[i][j] not in v:
                            v.add(board[i][j])
                        else:
                            return False
                
        return True