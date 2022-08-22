# Time Complexity: O(n^2)
# Space Complexity: O(1)

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        for i in range(len(board)):
            h = set()
            for j in range(len(board[0])):
                if board[i][j]!= '.':
                    if board[i][j] in h:
                        return False
                    h.add(board[i][j])
                    
        for j in range(len(board)):
            h = set()
            for i in range(len(board[0])):
                if board[i][j]!= '.':
                    if board[i][j] in h:
                        return False
                    h.add(board[i][j])
        
        for i in range(len(board)):
            h = set()
            for r in range((i//3)*3,((i//3)*3)+3):
                for c in range((i%3)*3,((i%3)*3)+3):
                    if board[r][c]!= '.':
                        if board[r][c] in h:
                            return False
                        h.add(board[r][c])
        return True