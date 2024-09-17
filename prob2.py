# Time Complexity : O(n^2) for n characters repeated k times on average
# Space Complexity : O(n^2) for stack space
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Yes, took a little of time to get it right
# Your code here along with comments explaining your approach

# for each row, column and block, maintain a boolean array of size 9 
# if any position in that array is not '.' and is True, return False
# else mark it true and continue 
# in the end return true

class Solution:

    def isValidSudoku(self, board):

        if board is None or len(board) == 0:
            return False
        
        # for row
        for i in range(9):
            row = [False] * 9
            for j in range(9):
                if board[i][j] != '.':
                    if row[int(board[i][j]) - 1]:
                        return False
                    row[int(board[i][j]) - 1] = True
        
        # for column
        for j in range(9):
            col = [False] * 9
            for i in range(9):
                if board[i][j] != '.':
                    if col[int(board[i][j]) - 1]:
                        return False
                    col[int(board[i][j]) - 1] = True
        
        # for block
        for block in range(9):
            blk = [False] * 9
            for i in range(block // 3*3, block //3*3+3, 1):
                for j in range(block % 3*3, block % 3*3+3, 1):

                    if board[i][j] != '.':
                        if blk[int(board[i][j]) - 1]:
                            return False
                        blk[int(board[i][j]) - 1] =  True
        
        return True