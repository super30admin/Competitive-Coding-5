'''
S30 Big N Problem #69 {Medium}

LC - 36. Valid Sudoku


 Time Complexity : O(n^m) n=rows,m=cols
 Space Complexity : O(1) 
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No 

 Approach
 
 1. traverse through each cell in the board
 2. maintain 3 dictionaries for rows, cols and soduku 3*3 boxes
 3. for each cell element, check present in rows, cols and boxes dictionaries.
 4. if already present, then its duplicate. so return false
 5. else add it to the dictionaries
'''
from collections import defaultdict
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        return self.helper(board)
        
    
    def helper(self,board):
        
        row=defaultdict(list)
        col=defaultdict(list)
        box=defaultdict(list)
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                
                if board[i][j]=='.':
                    continue
                if board[i][j] in row[i]:
                    return False
                elif board[i][j] in col[j]:
                    return False
                elif board[i][j] in box[self.getBox(i,j)]:
                    return False
                else:
                    row[i].append(board[i][j])
                    col[j].append(board[i][j])
                    box[self.getBox(i,j)].append(board[i][j])
        return True
                
        
        
    
    
    def getBox(self,row,col):
        
        return (row//3)*3+(col//3)
