# Time Complexity : O(9*9)
# Space Complexity : 0(9)

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if board == None or len(board) == 0 or len(board[0]) == 0:
            return False

        # row wise check
        for i in range(9):
            check = [False] * 9
            for j in range(9):
                if board[i][j] != ".":
                    if check[int(board[i][j]) - 1]:
                        return False
                    check[int(board[i][j]) - 1] = True

        # column wise check
        for j in range(9):
            check = [False] * 9
            for i in range(9):
                if board[i][j] != ".":
                    if check[int(board[i][j]) - 1]:
                        return False
                    check[int(board[i][j]) - 1] = True

        # block check
        for block in range(9):
            check = [False] * 9
            for i in range(block//3*3, block//3*3+3):
                for j in range(block%3*3, block%3*3+3):
                    if board[i][j] != ".":
                        if check[int(board[i][j]) - 1]:
                            return False
                        check[int(board[i][j]) - 1] = True

        return True