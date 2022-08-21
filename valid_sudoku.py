# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        rows = collections.defaultdict(set)
        cols = collections.defaultdict(set)
        squares = collections.defaultdict(set)
        
        m = len(board)
        for i in range(m):
            for j in range(m):
                if board[i][j] == ".":
                    continue
                if (board[i][j] in rows[i] or board[i][j] in cols[j] or board[i][j] in squares[(i//3, j//3)]):
                    return False
                rows[i].add(board[i][j])
                cols[j].add(board[i][j])
                squares[(i//3, j//3)].add(board[i][j])
                
        return True
                
            
