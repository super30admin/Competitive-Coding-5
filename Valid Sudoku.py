class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row, col, grid = set(), set(), set()
        for i in range(9):
            for j in range(9):
                if board[i][j]!= "." :
                    r_k= (i, board[i][j])
                    c_k= (j, board[i][j])
                    g_k= (i//3 , j//3 , board[i][j])
                    if (r_k in row or c_k in col or g_k in grid):
                        return False
                    row.add(r_k)
                    col.add(c_k)
                    grid.add(g_k)
                
        return True        
                
