# Time Complexity: O(n^3)
# Space Complexity: O(n)
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        # Row
        for i in range(9):
            boolean = [False for x in range(10)]
            for j in range(9):
                if board[i][j] != ".":
                    if boolean[int(board[i][j])]: return False
                    boolean[int(board[i][j])] = True
        # Col
        for i in range(9):
            boolean = [False for y in range(10)]
            for j in range(9):
                if board[j][i] != ".":
                    if boolean[int(board[j][i])]: return False
                    boolean[int(board[j][i])] = True
        # Block
        for i in range(0, 9, 3):
            for j in range(0, 9, 3):
                boolean = [False for z in range(10)]
                for y in range(i, i+3):
                    for z in range(j, j+3):
                        if board[y][z] != ".":
                            if boolean[int(board[y][z])]: return False
                            boolean[int(board[y][z])] = True
        return True
            