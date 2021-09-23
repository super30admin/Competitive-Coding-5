# // Time Complexity : O(1) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : none

# // Your code here along with comments explaining your approach 
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = len(board)
        cols = len(board[0])
        
        # check for rows
        for i in range(rows):
            numSet = set()
            for j in range(cols):
                if board[i][j] != "." and board[i][j] in numSet:
                    print(i,j)
                    return False
                else:
                    if board[i][j] != ".": numSet.add(board[i][j])
                    
        # check for cols
        for j in range(cols):
            numSet = set()
            for i in range(rows):
                if board[i][j] != "." and board[i][j] in numSet:
                    return False
                else:
                    if board[i][j] != ".": numSet.add(board[i][j])
                    
        # check for 3*3 boxes
        for k in range(0,9,3):
            for p in range(0,9,3):
                numSet = set() 
                for i in range(k,k+3):
                    for j in range(p,p+3):
                        # print(i,j)
                        if board[i][j] != "." and board[i][j] in numSet:
                            return False
                        else:
                            if board[i][j] != ".": numSet.add(board[i][j])
        return True