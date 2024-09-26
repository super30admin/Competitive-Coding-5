# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # DFS approach
        global flag, hset
        flag = True
        hset = set()

        # Recursive Function
        def validate_rows(i, j):

            global flag
            if board[i][j] in hset or not flag:
                flag = False
                return
            if board[i][j] != '.':
                hset.add(board[i][j])
            if (i + 1) < len(board):
                validate_rows(i + 1, j)

        # Recursive Function
        def validate_cols(i, j):
            global flag
            if board[i][j] in hset or not flag:
                flag = False
                return
            if board[i][j] != '.':
                hset.add(board[i][j])
            if (j + 1) < len(board[0]):
                validate_cols(i, j + 1)

        def validate_3x3(i, j):
            global flag
            if not flag:
                return
            for r in range(i, i + 3):
                for c in range(j, j + 3):

                    if board[r][c] == '.':
                        continue
                    if board[r][c] in hset:
                        flag = False
                        return
                    hset.add(board[r][c])

        # Main code
        # Validate Cols
        for i in range(len(board)):
            if flag:
                hset.clear()
                validate_cols(i, 0)
                # print("Col at row", i, "is", hset)
                # print("Flag", flag)
            else:
                # print("Failed at col check at row", i)
                # print(hset)
                return flag

        # Validate rows
        if not flag:
            return flag
        for j in range(len(board[0])):
            if flag:
                hset.clear()
                validate_rows(0, j)
                # print("Row at col", j, "is", hset)
                # print("Flag", flag)
            else:
                # print("Failed at row check at col", j)
                return flag

        # Validate 3x3 boxes
        if not flag:
            return flag
        for i in range(0, len(board), 3):
            for j in range(0, len(board[0]), 3):
                hset.clear()
                validate_3x3(i, j)
                # print("3x3", i, j)
                # print(hset)
        return flag
