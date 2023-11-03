# // Time Complexity :O(9^3)
# // Space Complexity :O(9)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we are checking each row and columna dn block one by one. 
# if there is a value found we add it to a set and if we see same value in the set coming again in that row/col/block we return false. 
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
      
        if (board is None or len(board) != 9 or len(board[0]) != 9):
            return False
        # row
        for i in range(9):
            row_set=set()
            for j in range(9):
                if(board[i][j]!='.'):
                    if(board[i][j] in row_set):
                        return False
                    row_set.add(board[i][j])

        # columns
        for j in range(9):
            row_set=set()
            for i in range(9):
                if(board[i][j]!='.'):
                    if(board[i][j] in row_set):
                        return False
                    row_set.add(board[i][j])
        
        # block
        for block in range(9):
            row_set=set()
            for i in range(block/3*3, block/3*3+3):
                for j in range(block%3*3, block%3*3+3):
                    if(board[i][j]!='.'):
                        if(board[i][j] in row_set):
                            return False
                       