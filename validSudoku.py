#Accepted on Leetcode
#Time complexity - O(N) as we are visiting every element
#Space complexity - O(N) for boolean array

class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        #Edge Case
        if board == None or len(board) == 0 or len(board[0]) == 0:
            return False
        
        #Checking the validity of rows
        for i in range(9):
            b = [False]*9
            for j in range(9):
                if board[i][j] != '.':
                    #If the element is already present,then (element-1) index of boolean array b will already be True. Return False in that case
                    if b[int(board[i][j]) - 1] == True:
                        return False
                    #If the element not present,then make (element-1) index of boolean array b = True
                    else:
                        b[int(board[i][j]) - 1] = True
        #Checking the validity of columns
        for j in range(9):
            b = [False]*9
            for i in range(9):
                if board[i][j] != '.':
                    #If the element is already present,then (element-1) index of boolean array b will already be True. Return False in that case
                    if b[int(board[i][j]) - 1] == True:
                        return False
                    #If the element not present,then make (element-1) index of boolean array b = True
                    else:
                        b[int(board[i][j]) - 1] = True
        #Checking validity of block
        for block in range(9):
            b = [False]*9
            for i in range((block/3)*3, (block/3)*3 + 3):
                for j in range((block%3)*3, (block%3)*3 + 3):
                    if board[i][j] != '.':
                        #If the element is already present,then (element-1) index of boolean array b will already be True. Return False in that case
                        if b[int(board[i][j]) - 1] == True:
                            return False
                        #If the element not present,then make (element-1) index of boolean array b = True
                        else:
                            b[int(board[i][j]) - 1] = True
        return True