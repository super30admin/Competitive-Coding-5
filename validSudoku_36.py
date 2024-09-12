
# // Time Complexity : O(1)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
#create three sets, all with pre-defined lengths -> hence constant space
#for each row, col and smaller grid -> check if value exists in hashmap
#if it does, return invalid sudoku
#if it doesn't, keep on adding all the values

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        rowSet = [set() for i in range(9)]
        colSet = [set() for i in range(9)]
        gridSet = [set() for i in range(9)]
        
        for i in range(9):
            for j in range(9):
                cur = board[i][j]
                if cur != ".":
                    
                    #rows
                    if cur not in rowSet[i]:
                        rowSet[i].add(cur)
                    else:
                        return False
                    
                    #cols
                    if cur not in colSet[j]:
                        colSet[j].add(cur)
                    else:
                        return False
                    
                    #grid
                    gridIndex = (i//3)*3 + j//3
                    if cur not in gridSet[gridIndex]:
                        gridSet[gridIndex].add(cur)
                    else:
                        return False
                    
        return True
                    
                    
                    
                
                        
                        


