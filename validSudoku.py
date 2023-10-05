# Time Complexity: O(mn) --> O(9^2)
# Space Complexity: O(n) --> 0(9)

class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        rowSet = collections.defaultdict(set)
        colSet = collections.defaultdict(set)
        boxSet = collections.defaultdict(set)
        for i in range (9):
            for j in range (9):
                if board[i][j] == ".":
                    continue
                if (board[i][j] in rowSet[i]) or (board[i][j] in colSet[j]) or (board[i][j] in boxSet[(i//3, j//3)]):
                    return False
                
                rowSet[i].add(board[i][j])
                colSet[j].add(board[i][j])
                boxSet[(i//3, j//3)].add(board[i][j])

        return True
