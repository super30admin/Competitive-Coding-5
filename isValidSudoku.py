class Solution:
    def isValidSudoku(self, board) -> bool:
        row = [set() for i in range(9)]
        col = [set() for i in range(9)]
        box = [set() for i in range(9)]

        for i in range(9):
            for j in range(9):
                val = board[i][j]
                if val == ".":
                    continue

                if val in row[i]:
                    return False
                row[i].add(val)
                if val in col[j]:
                    return False
                col[j].add(val)

                id = (i // 3) * 3 + (j//3)
                if val in box[id]:
                    return False
                box[id].add(val)

        return True

#TC: O(n*n)
#SC: O(n*n)