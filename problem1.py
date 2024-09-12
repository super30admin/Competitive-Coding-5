# TC:O(n^2)
# SC:O(10 * 3 * n) we can ignore 30.

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:

        if board is None:
            return None

        for i in range(len(board)):
            if self.checkrows(board, i) == False or self.checkcolums(board, i) == False:
                return False

        for i in range(0, len(board), 3):
            for j in range(0, len(board[0]), 3):
                if self.checkGrid(board, i, j) == False:
                    return False

        return True

    def checkrows(self, board, n):
        temp = [False] * 10

        for i in range(len(board)):
            if board[n][i] != "." and temp[int(board[n][i])] == False:

                temp[int(board[n][i])] = True
            elif board[n][i] == ".":
                continue
            else:
                return False

        return True

    def checkcolums(self, board, n):
        temp = [False] * 10
        for i in range(len(board)):
            if board[i][n] != "." and temp[int(board[i][n])] == False:
                temp[int(board[i][n])] = True
            elif board[i][n] == ".":
                continue
            else:
                return False
        return True

    def checkGrid(self, board, m, n):
        temp = [False] * 10
        for i in range(m, m + 3):
            for j in range(n, n + 3):
                if board[i][j] != "." and temp[int(board[i][j])] == False:
                    temp[int(board[i][j])] = True
                elif board[i][j] == ".":
                    continue
                else:
                    return False
        return True


