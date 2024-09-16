'''
Solution:
1.  To check whether a sudoku board is valid or not, we check 3 main things.
2.  Check whether a particular block contains no repeating number between 1-9; check whether a particular row contains
    no repeating number between 1-9; check whether a particular column contains no repeating number between 1-9
3.  If everything is valid, return true else false
Time Complexity:    O(m x n)    as each cell in the board is traversed 3 times at maximun
Space Complexity:   O(1)        as each group of 9 cells to be checked, we require a HashMap of size 9 at maximum
--- Passed all testcases on Leetcode successfully
'''

class Solution:   
    
    def __validRow(self, r, board):

        #   maintain a dictionary to check the presence of digits
        dictNums = {}
        for c in range(9):

            #   cell that can be ignored
            if board[r][c] == '.':
                continue

            #   checking already existence
            elif board[r][c] in dictNums or int(board[r][c]) < 1 or int(board[r][c]) > 9:
                return False

            #   update the dictionary
            else:
                dictNums[board[r][c]] = 1

        #   if everything is fine, return true
        return True

    def __validCol(self, c, board):

        #   maintain a dictionary to check the presence of digits
        dictNums = {}
        for r in range(9):

            #   cell that can be ignored
            if board[r][c] == '.':
                continue

            #   checking already existence
            elif board[r][c] in dictNums or int(board[r][c]) < 1 or int(board[r][c]) > 9:
                return False

            #   update the dictionary
            else:
                dictNums[board[r][c]] = 1

        #   if everything is fine, return true
        return True

    def __validBlock(self, row, col, board):

        #   maintain a dictionary to check the presence of digits
        dictNums = {}
        for r in range(row, row + 3):
            for c in range(col, col + 3):

                #   cell that can be ignored
                if board[r][c] == '.':
                    continue

                #   checking already existence
                elif board[r][c] in dictNums or int(board[r][c]) < 1 or int(board[r][c]) > 9:
                    return False

                #   update the dictionary
                else:
                    dictNums[board[r][c]] = 1

        #   if everything is fine, return true
        return True

    

    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        #   Check whether a particular block contains no repeating number between 1-9
        for row in range(0, 9, 3):
            for col in range(0, 9, 3):
                if not self.__validBlock(row, col, board):
                    return False

        #   Check whether a particular row contains no repeating number between 1-9
        for row in range(9):
            if not self.__validRow(row, board):
                return False

        #   Check whether a particular column contains no repeating number between 1-9
        for col in range(9):
            if not self.__validCol(col, board):
                return False

        return True
        