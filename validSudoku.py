# Time Complexity : O(1), because it will always be a 9x9 board.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : yes, took me ample time to come around with the solution.

# Your code here along with comments explaining your approach
from collections import defaultdict
class Solution(object):
    # This approach uses 3 dictionaries, where every key is
    # row/column/3x3 box and the value is associated to it.
    # before inserting any value, a check is performed to make sure it's unique in
    # it's row/column/3x3 box, if not return False. Otherwise in the end return True.
    def isValidSudoku(self, board):
        if not board: return True

        storeRow = defaultdict(set)
        storeCol = defaultdict(set)
        storeBox = defaultdict(set)

        for i in range(9):
            for j in range(9):
                val = board[i][j]
                if val != '.':
                    if val in storeRow[i] or val in storeCol[j] or val in storeBox[(i/3, j/3)]:
                        return False
                    storeRow[i].add(val)
                    storeCol[j].add(val)
                    storeBox[(i/3, j/3)].add(val)

        return True

# False
board = [
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]]

# True
# board = [
#     ["5","3",".",".","7",".",".",".","."],
#     ["6",".",".","1","9","5",".",".","."],
#     [".","9","8",".",".",".",".","6","."],
#     ["8",".",".",".","6",".",".",".","3"],
#     ["4",".",".","8",".","3",".",".","1"],
#     ["7",".",".",".","2",".",".",".","6"],
#     [".","6",".",".",".",".","2","8","."],
#     [".",".",".","4","1","9",".",".","5"],
#     [".",".",".",".","8",".",".","7","9"]]

s = Solution()
print s.isValidSudoku(board)
