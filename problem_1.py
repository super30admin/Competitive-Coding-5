# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach

# one pass
# Using default-dict
# creating keys dynamically in dictionary
from collections import defaultdict


class Solution:
    def isValidSudoku(self, board: list[list[str]]) -> bool:
        rowset = defaultdict(set)
        columnset = defaultdict(set)
        grid = defaultdict(set)
        m = len(board)
        for i in range(m):
            for j in range(m):
                if board[i][j] != '.':
                    if board[i][j] in rowset[i] or board[i][j] in columnset[j] or board[i][j] in grid[(i // 3, j // 3)]:
                        return False
                    rowset[i].add(board[i][j])
                    columnset[j].add(board[i][j])
                    grid[(i // 3, j // 3)].add(board[i][j])
        return True


print(Solution().isValidSudoku(
    [[".", ".", "4", ".", ".", ".", "6", "3", "."], [".", ".", ".", ".", ".", ".", ".", ".", "."],
     ["5", ".", ".", ".", ".", ".", ".", "9", "."], [".", ".", ".", "5", "6", ".", ".", ".", "."],
     ["4", ".", "3", ".", ".", ".", ".", ".", "1"], [".", ".", ".", "7", ".", ".", ".", ".", "."],
     [".", ".", ".", "5", ".", ".", ".", ".", "."], [".", ".", ".", ".", ".", ".", ".", ".", "."],
     [".", ".", ".", ".", ".", ".", ".", ".", "."]]))


# TC: O(m*n); SC: O(m*n)
# one pass
# pre-defining keys in dictionary.
# class Solution:
#     def isValidSudoku(self, board: list[list[str]]) -> bool:
#         rowset = {0: set(), 1: set(), 2: set(), 3: set(), 4: set(), 5: set(), 6: set(), 7: set(), 8: set()}
#         columnset = {0: set(), 1: set(), 2: set(), 3: set(), 4: set(), 5: set(), 6: set(), 7: set(), 8: set()}
#         grid = {(0, 0): set(), (0, 1): set(), (0, 2): set(), (1, 0): set(), (1, 1): set(), (1, 2): set(), (2, 0): set(),
#                 (2, 1): set(), (2, 2): set()}
#         m = len(board)
#         n = len(board[0])
#         for i in range(m):
#             for j in range(n):
#                 if board[i][j] in rowset[i] or board[i][j] in grid[(i // 3, j // 3)] or board[i][j] in columnset[j]:
#                     return False
#                 if board[i][j] != '.':
#                     rowset[i].add(board[i][j])
#                     columnset[j].add(board[i][j])
#                     grid[(i // 3, j // 3)].add(board[i][j])
#         return True
#
#
# print(Solution().isValidSudoku(
#     [[".", ".", "4", ".", ".", ".", "6", "3", "."], [".", ".", ".", ".", ".", ".", ".", ".", "."],
#      ["5", ".", ".", ".", ".", ".", ".", "9", "."], [".", ".", ".", "5", "6", ".", ".", ".", "."],
#      ["4", ".", "3", ".", ".", ".", ".", ".", "1"], [".", ".", ".", "7", ".", ".", ".", ".", "."],
#      [".", ".", ".", "5", ".", ".", ".", ".", "."], [".", ".", ".", ".", ".", ".", ".", ".", "."],
#      [".", ".", ".", ".", ".", ".", ".", ".", "."]]))


# TC: O(m*n) + O(m*n) --> O(m*n); SC: O(m*n)
# two-pass
# class Solution:
#     def isValidSudoku(self, board: list[list[str]]) -> bool:
#         rowset = set()
#         columnset = set()
#         grid = {(0, 0): set(), (0, 1): set(), (0, 2): set(), (1, 0): set(), (1, 1): set(), (1, 2): set(), (2, 0): set(),
#                 (2, 1): set(), (2, 2): set()}
#         x = grid
#         m = len(board)
#         n = len(board[0])
#         for i in range(m):
#             for j in range(n):
#                 if board[i][j] in rowset or board[i][j] in grid[(i // 3, j // 3)]:
#                     return False
#                 if board[i][j] != '.':
#                     rowset.add(board[i][j])
#                     grid[(i // 3, j // 3)].add(board[i][j])
#             rowset = set()
#         grid = {(0, 0): set(), (0, 1): set(), (0, 2): set(), (1, 0): set(), (1, 1): set(), (1, 2): set(), (2, 0): set(),
#                 (2, 1): set(), (2, 2): set()}
#         for j in range(m):
#             for i in range(n):
#                 if board[i][j] in columnset or board[i][j] in grid[(i // 3, j // 3)]:
#                     return False
#                 if board[i][j] != '.':
#                     columnset.add(board[i][j])
#                     grid[(i // 3, j // 3)].add(board[i][j])
#             columnset = set()
#         return True
#
# print(Solution().isValidSudoku(
#     [[".", ".", "4", ".", ".", ".", "6", "3", "."], [".", ".", ".", ".", ".", ".", ".", ".", "."],
#      ["5", ".", ".", ".", ".", ".", ".", "9", "."], [".", ".", ".", "5", "6", ".", ".", ".", "."],
#      ["4", ".", "3", ".", ".", ".", ".", ".", "1"], [".", ".", ".", "7", ".", ".", ".", ".", "."],
#      [".", ".", ".", "5", ".", ".", ".", ".", "."], [".", ".", ".", ".", ".", ".", ".", ".", "."],
#      [".", ".", ".", ".", ".", ".", ".", ".", "."]]))
