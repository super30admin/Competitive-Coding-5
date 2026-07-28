from typing import List

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        seen = set()
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    if (board[i][j] + " found in row " + str(i)) in seen or \
                       (board[i][j] + " found in col " + str(j)) in seen or \
                       (board[i][j] + " found in box " + str(i // 3) + "-" + str(j // 3)) in seen:
                        return False
                    seen.add(board[i][j] + " found in row " + str(i))
                    seen.add(board[i][j] + " found in col " + str(j))
                    seen.add(board[i][j] + " found in box " + str(i // 3) + "-" + str(j // 3))
        return True

# TC - O(1)
# SC - O(1)