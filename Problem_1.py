class Solution:
    def isValidSudoku(self, board):
        N = len(board)
        row = [set() for _ in range(N)]
        col = [set() for _ in range(N)]
        box = [set() for _ in range(N)]
        for i in range(N):
            for j in range(N):
                curr = board[i][j]
                if curr == ".":
                    continue

                if curr in row[i]:
                    return False
                else:
                    row[i].add(curr)

                if curr in col[j]:
                    return False
                else:
                    col[j].add(curr)

                boxNum = (i // 3) * 3 + j // 3

                if curr in box[boxNum]:
                    return False
                else:
                    box[boxNum].add(curr)
        return True
