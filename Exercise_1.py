#Time Complexity : O(N)), N being the number of values in matrix. 
#Space Complexity : O(N+M), N being the number of values in row and M begin number of values in col. 
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Was going to hardcode it. Had a little trouble figuring
#out the non-hardcoded way.
#Your code here along with comments explaining your approach in three sentences only
'''Create a set and add values into set. If value is in set, there is a duplicate. Do the same for the 
3x3 grids. 
'''
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        #create an empty set for each grid. 
        grid = [[set() for i in range(3)] for j in range(3)]
        #parse through the values and add to sets. 
        for i in range(9):
            rows = set()
            cols = set()
            for j in range(9):
                #add values to rows and check for duplicates. 
                if board[i][j]!=".":
                     
                    if board[i][j] in rows:
                        return False
                    else:
                        rows.add(board[i][j])
                    #calculate grid number and then add to grid and check duplicates. 
                    r_grid = int(i/3)
                    c_grid = int(j/3)
                    
                    g = grid[r_grid][c_grid]
                    if board[i][j] in g:
                        return False
                    else:
                        grid[r_grid][c_grid].add(board[i][j])

            #add values to cols and check for duplicates.     
            for j in range(9):
                if board[j][i]!=".":
                    if board[j][i] in cols:
                        return False
                    else:
                        cols.add(board[j][i]) 
        return True