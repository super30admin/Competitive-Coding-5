class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """

        # Time: O(m**2)
        # Space: O(m**2)
        row = collections.defaultdict(list)
        column = collections.defaultdict(list)
        grid = collections.defaultdict(list)

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] != '.':
                    # Check number in row
                    if board[i][j] in row[i]: return False
                    row.get(i, []).append(board[i][j])

                    # Check number in column
                    if board[i][j] in column[j]: return False
                    column.get(j, []).append(board[i][j])

                    # check number in grid
                    if board[i][j] in grid[(i // 3, j // 3)]: return False
                    grid[(i // 3, j // 3)].append(board[i][j])

        return True

