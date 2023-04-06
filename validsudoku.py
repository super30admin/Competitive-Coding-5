#TC-O(mn)
#SC-O(1)
#check through each row,column and blocks by creating a list of 9 elememts and if already tracked
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        #rows
        for i in range(9):
            li = [False for i in range(9)]
            for j in range(9):
                if board[i][j]!='.':
                    if li[int(board[i][j])-1]:
                        return False
                    li[int(board[i][j])-1] = True
        
        #columns
        for j in range(9):
            li = [False for i in range(9)]
            for i in range(9):
                if board[i][j]!='.':
                    if li[int(board[i][j])-1]:
                        return False
                    li[int(board[i][j])-1] = True
        
        #blocks
        col = [[0,1,2],[3,4,5],[6,7,8]]
        row=[[0,1,2],[3,4,5],[6,7,8]]
        blocks=[]
        for i in col:
            for j in row:
                blocks.append([j,i])
        for b in blocks:
            li = [False for i in range(9)]
            for r in b[0]:
                for c in b[1]:
                    if board[r][c]!='.':
                        if li[int(board[r][c])-1]:
                            return False
                        li[int(board[r][c])-1] = True
        return True

