
# TIme complexity - O(n^2)
# Space complexity - O(n^2)
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        n = len(board)

        for i in range(n):
            seen = set()
            for j in range(n):
                # check the row
                if board[i][j] != "." and board[i][j] in seen:
                    return False
                seen.add(board[i][j])

        # check the column
        for j in range(n):
            seen = set()
            for i in range(n):
                # check the row
                if board[i][j] != "." and board[i][j] in seen:
                    return False
                seen.add(board[i][j])
               
        # check the 3x3 matrix
        for i in range(0,9,3):
            for j in range(0,9,3):
                seen = set()
                for r in range(0+i, 3+i):
                    for c in range(0+j, 3+j):
                        if board[r][c] != "." and board[r][c] in seen:
                            return False
                        seen.add(board[r][c])
               
        return True
