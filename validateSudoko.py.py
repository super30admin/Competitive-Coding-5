'''
Time:O(m x n)
Space: O(1)   
'''
class ValidSudoku(object):

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