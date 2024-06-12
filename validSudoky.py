class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = defaultdict(set)
        cols = defaultdict(set)
        zones = defaultdict(set)
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]!=".":
                    if board[i][j] in rows[i] or board[i][j] in cols[j] or board[i][j] in zones[(i//3, j//3)]:
                        return False
                    else:
                        rows[i].add(board[i][j])
                        cols[j].add(board[i][j])
                        zones[(i//3, j//3)].add(board[i][j])
        return True

Time: O(1)
Space = (1)