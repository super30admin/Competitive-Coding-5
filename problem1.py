# Time and space complexity is O(9^2)
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        

        rows= collections.defaultdict(set)
        cols=collections.defaultdict(set)
        sqrs = collections.defaultdict(set)
        
        for r in range(9):
            for c in range(9):
                if board[r][c]=='.':
                    continue
                
                if board[r][c] in rows[r] or board[r][c] in cols[c] or board[r][c] in sqrs[(r//3, c//3)]:
                    return False
                
                rows[r].add(board[r][c])
                cols[c].add(board[r][c])
                sqrs[(r//3, c//3)].add(board[r][c])
                
                
        return True
                    
        
        