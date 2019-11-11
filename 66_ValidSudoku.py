# Accepted on leetcode(36)
# time - O(M*N), space - O(1)
# Iterate through grid for 3 times one for row and one for column and one for block.
# and check if anything repeats only for filled cells.

class Solution:
    def isValidSudoku(self, board) -> bool:
        # edge case
        if len(board) != 9 or len(board[0]) != 9 or not board:
            print('hi')
            return False
        # validating each row using the boolean array
        for i in range(9):
            b = [False for i in range(9)]
            for j in range(9):
                if board[i][j] != '.':
                    if b[int(board[i][j]) - 1]:  # if true, number already exists so return false
                        return False
                    b[int(board[i][j]) - 1] = True

        # validating column
        for j in range(9):
            b = [False for i in range(9)]
            for i in range(9):
                if board[i][j] != '.':
                    if b[int(board[i][j]) - 1]:
                        print('column-False')
                        return False
                    b[int(board[i][j]) - 1] = True

        # validating block
        for block in range(9):
            b = [False for i in range(9)]

            for i in range(block // 3 * 3, block // 3 * 3 + 3):  # taken quotient
                for j in range(block % 3 * 3, block % 3 * 3 + 3):  # taken remainder
                    if board[i][j] != '.':
                        if b[int(board[i][j]) - 1]:
                            print('block-false')
                            return False
                        b[int(board[i][j]) - 1] = True
                        # print(b[int(board[i][j])-1])

        return True
