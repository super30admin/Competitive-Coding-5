#tc==> O(n)
#sc===> O(1)
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for row in range(len(board)):
            for col in range(len(board[0])):
                if self.sudoku(board,row,col)==False:
                    return False
        return True
    def sudoku(self,board,row,col):
        if board[row][col]==".":
            return True  
        for i in range(len(board)):
            if i!=row and board[i][col]==board[row][col]:
                return False
        for j in range(len(board[0])):
            if j!=col and board[row][j]==board[row][col]:
                return False
        for i in range(row//3*3,row//3*3+3):
            for j in range(col//3*3,col//3*3+3):
                if (i!=row or j!=col) and board[i][j]==board[row][col]:
                    return False
        return True