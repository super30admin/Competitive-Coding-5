# Time Complexity: O(1)
# Space Complexity: O(1)
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        def isValidHelper(board, i, j):
            val = board[i][j]

            # Check row
            for k in range(9):
                if k != j and board[i][k] == val:
                    return False

            # Check column
            for l in range(9):
                if l != i and board[l][j] == val:
                    return False

            # Check 3x3 box
            boxRow = i - (i % 3)
            boxCol = j - (j % 3)
            for m in range(boxRow, boxRow + 3):
                for n in range(boxCol, boxCol + 3):
                    if (m != i or n != j) and board[m][n] == val:
                        return False

            return True

        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    if not isValidHelper(board, i, j):
                        return False

        return True