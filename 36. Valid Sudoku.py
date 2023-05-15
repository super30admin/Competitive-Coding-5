#Time Complexity:O(n^2)
#Space Complexity:O(n^2)

class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        row=defaultdict(set)
        column=defaultdict(set)
        grid=defaultdict(set)
        for i in range(len(board)):
            for j in range(len(board)):
                if board[i][j] =='.':
                    continue
                if (board[i][j] in row[i]) or (board[i][j] in column[j]) or (board[i][j] in grid[(i//3,j//3)]):
                    return False
                row[i].add(board[i][j])
                column[j].add(board[i][j])
                grid[(i//3,j//3)].add(board[i][j])
        return True
                