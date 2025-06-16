# TC: O(1)
# SC: O(1)
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        hmap={}
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==".":
                    continue
                if board[i][j] not in hmap:
                    #                     row        col       grid
                    hmap[board[i][j]] = [[False]*9,[False]*9,[False]*9]

                # row check
                if hmap[board[i][j]][0][i] == True:
                    return False
                else:
                    hmap[board[i][j]][0][i]=True
                
                # col check 
                if hmap[board[i][j]][1][j] == True:
                    return False
                else:
                    hmap[board[i][j]][1][j]=True
                
                #grid check
                if hmap[board[i][j]][2][(i//3)*3+(j//3)]==True:
                    return False
                else:
                    hmap[board[i][j]][2][(i//3)*3+(j//3)]=True
        
        
        return True