# Time Complexity : Add - O(1) - dimension is a fixed 9*9 matrix
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''

1. check each row for repeatedness by maintaing a hashset
2. check each row for repeatedness by maintaing a hashset
3. check each block for repeatedness by maintaing a hashset

'''

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        
        if not board or len(board) < 1 or len(board[0]) < 1:
            return
        
        rows= len(board)
        cols = len(board[0])
        
        for i in range(rows):
            hash_list = [False]*len(board[0])
            for j in range(cols):
                if board[i][j] != '.':
                    # print (board[i][j])
                    if hash_list[int(board[i][j])-1]:
                        return False
                    else:
                        hash_list[int(board[i][j])-1] = True
            
        for j in range(cols):
            hash_list = [False]*len(board)
            for i in range(rows):
                if board[i][j] != '.':
                    if hash_list[int(board[i][j])-1]:
                        return False
                    else:
                        hash_list[int(board[i][j])-1] = True
                        
        #no. of total blocks
        for block in range(len(board)):
            hash_list = [False]*len(board[0])
            for i in range(block//3 * 3, block//3 * 3 +3):
                
                for j in range(block%3 * 3, block%3 * 3 +3):
                    if board[i][j] != '.':
                        if hash_list[int(board[i][j])-1]:
                            return False
                        else:
                            hash_list[int(board[i][j])-1] = True
        return True
                    
                        
        
        
        
                        
                    
        