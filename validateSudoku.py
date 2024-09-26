'''
time complexity: O(R*C)
space complexity: O(R*C)
R C are row and column
'''
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row = [set() for _ in range(len(board))]
        col = [set() for _ in range(len(board))]
        square = [set() for _ in range(len(board))]
        
        
        for r in range(len(board)):
            for c in  range(len(board[0])):
                if board[r][c] == ".":
                    continue
                if board[r][c] in row[r]:
                    return False
                row[r].add(board[r][c])
                
                if board[r][c] in col[c]:
                    return False
                col[c].add(board[r][c])
                
                sq = (r//3)*3 + (c//3)
                if board[r][c] in square[sq]:
                    return False
                square[sq].add(board[r][c])
        return True