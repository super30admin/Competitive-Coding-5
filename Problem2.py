# Used 3 sets approach for rows, cols and boxes and if it's a duplicate we return False
# TC: O(N^2) for generic case if it's not a 9 x 9 sudoku
# SC: O(N^2) for generic case if it's not just a 9 x 9 sudoku
# Yes, this worked in leetcode

class Solution(object):
    def isValidSudoku(self, board):
        res = []
        for i in range(9):
            for j in range(9):
                element = board[i][j]
                if element != '.':
                    res += [(i, element), (element, j), (i // 3, j // 3, element)]
        return len(res) == len(set(res))

# class Solution:
#     def isValidSudoku(self, board: List[List[str]]) -> bool:
#         N = 9
#         rows = [set() for _ in range(N)]
#         cols = [set() for _ in range(N)]
#         boxes = [set() for _ in range(N)]

#         for r in range(N):
#             for c in range(N):
#                 val = board[r][c]

#                 if val == ".":
#                     continue
#                 if val in rows[r]:
#                     return False
#                 rows[r].add(val)

#                 if val in cols[c]:
#                     return False
#                 cols[c].add(val)

#                 idx = (r // 3) * 3 + c // 3
#                 if val in boxes[idx]:
#                     return False
#                 boxes[idx].add(val)

#         return True
