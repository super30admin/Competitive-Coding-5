#TC: O(m x n) 
#SC: O(1) 

class Solution(object):
    def __validBlock(self, row, col, board):
        dictNums = {}
        for r in range(row, row + 3):
            for c in range(col, col + 3):
                if board[r][c] == '.':
                    continue
                elif board[r][c] in dictNums or int(board[r][c]) < 1 or int(board[r][c]) > 9:
                    return False
                else:
                    dictNums[board[r][c]] = 1
        return True

    def __validRow(self, r, board):
        dictNums = {}
        for c in range(9):
            if board[r][c] == '.':
                continue
            elif board[r][c] in dictNums or int(board[r][c]) < 1 or int(board[r][c]) > 9:
                return False
            else:
                dictNums[board[r][c]] = 1
        return True

    def __validCol(self, c, board):
        dictNums = {}
        for r in range(9):
            if board[r][c] == '.':
                continue
            elif board[r][c] in dictNums or int(board[r][c]) < 1 or int(board[r][c]) > 9:
                return False
            else:
                dictNums[board[r][c]] = 1
        return True

    def isValidSudoku(self, board):
        for row in range(0, 9, 3):
            for col in range(0, 9, 3):
                if not self.__validBlock(row, col, board):
                    return False
        for row in range(9):
            if not self.__validRow(row, board):
                return False
        for col in range(9):
            if not self.__validCol(col, board):
                return False
        return True