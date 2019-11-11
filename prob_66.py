#36 leetcode
#time O(m x n)
#space O(1)
#algo: Check for each row, col and 3 x 3 matrix
# leetcode 36
# validate filled cells in sudoku
# tine
# space
# algo : check for each row, columnd and each of 3 * 3 matrix and validate
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        # edgecase
        if not (board) or len(board) != 9 or len(board[0]) != 9:
            return False
        for i in range(9):  # checking for each row using array and updating it its present
            b = [False for i in range(9)]
            for j in range(9):
                if board[i][j] != '.':
                    if b[int(board[i][
                                 j]) - 1]:  # if value, that is value at board represented in array is value -1 ,  is true implies value exists in the row
                        return False
                    b[int(board[i][j]) - 1] = True
        for j in range(9):  # checking for each column using array and updating it its present
            b = [False for i in range(9)]
            for i in range(9):
                if board[i][j] != '.':
                    if b[int(board[i][j]) - 1]:  # if value is true implies value exists in the row
                        return False
                    b[int(board[i][j]) - 1] = True

        # validating block
        for block in range(9):
            b = [False for i in range(9)]

            for i in range(block // 3 * 3, block // 3 * 3 + 3):  # quotient
                for j in range(block % 3 * 3, block % 3 * 3 + 3):  # remainder
                    if board[i][j] != '.':
                        if b[int(board[i][j]) - 1]:
                            return False
                        b[int(board[i][j]) - 1] = True

        return True



