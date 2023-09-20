class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row=[[0 for _ in range(9)] for _ in range(9)]
        col=[[0 for _ in range(9)] for _ in range(9)]
        box=[[0 for _ in range(9)] for _ in range(9)]

        for i in range(9):
            for j in range(9):
                if board[i][j]==".":
                    continue
                
                pos=int(board[i][j])-1
                if row[i][pos]==1:
                    return False
                row[i][pos]=1
                if col[j][pos]==1:
                    return False
                col[j][pos]=1
                idx=(i//3)+(j//3)*3
                if box[idx][pos]==1:
                    return False
                box[idx][pos]=1
        return True