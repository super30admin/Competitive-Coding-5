# TC: O(N^2)
# SC: O(N)

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if board == None or len(board) != 9 or len(board[0]) != 9:
            return False

        rows, cols = len(board), len(board[0])
        # rows
        for r in range(rows):
            flag = [False] * 9
            for c in range(cols):
                if board[r][c] == '.':
                    continue
                else:
                    if flag[(int(board[r][c])) - 1] == True:
                        return False
                    flag[int(board[r][c]) - 1] = True

        # cols
        for c in range(cols):
            flag = [False] * 9
            for r in range(rows):
                if board[r][c] == '.':
                    continue
                else:
                    if flag[(int(board[r][c])) - 1] == True:
                        return False
                    flag[int(board[r][c]) - 1] = True

        #matrix
        for block in range(0, 9):
            flag = [False] * 9
            for r in range(int(block/3) * 3, int(block/3) * 3 + 3):
                for c in range(block%3 * 3, block%3 * 3 + 3):
                    if board[r][c] == '.':
                        continue
                    else:
                        if flag[(int(board[r][c])) - 1] == True:
                            return False
                        flag[int(board[r][c]) - 1] = True
        return True

        