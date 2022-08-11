class Solution:
    def isValidSudoku(self, board):
        if board is None or len(board) == 0:
            return False

        # row
        for i in range(9):
            b = [False for i in range(9)]
            for j in range(9):
                if board[i][j] != ".":
                    if b[int(board[i][j]) - 1]:
                        return False
                    b[int(board[i][j]) - 1] = True
        # column
        for j in range(9):
            b = [False for i in range(9)]
            for i in range(9):
                if board[i][j] != ".":
                    if b[int(board[i][j]) - 1]:
                        return False
                    b[int(board[i][j]) - 1] = True
        # block
        for b in range(9):
            li = [False] * 9
            # print((b/3 * 3))
            for i in range(b // 3 * 3, b // 3 * 3 + 3):
                for j in range((b % 3 * 3), (b % 3 * 3 + 3)):
                    # print(board[i][j])
                    if board[i][j] != ".":
                        if li[int(board[i][j]) - 1]:
                            return False
                        li[int(board[i][j]) - 1] = True
        return print(True)


if __name__ == "__main__":
    obj = Solution()
    obj.isValidSudoku([["5", "3", ".", ".", "7", ".", ".", ".", "."], ["6", ".", ".", "1", "9", "5", ".", ".", "."],
                       [".", "9", "8", ".", ".", ".", ".", "6", "."], ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
                       ["4", ".", ".", "8", ".", "3", ".", ".", "1"], ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
                       [".", "6", ".", ".", ".", ".", "2", "8", "."], [".", ".", ".", "4", "1", "9", ".", ".", "5"],
                       [".", ".", ".", ".", "8", ".", ".", "7", "9"]])
# TC =O(n).
# Space complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
