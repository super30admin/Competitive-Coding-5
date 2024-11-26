#Time Comp- we are traversing column*row - O(n*n)
#space comp-O(n) we are using three hashsets to store values
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        #lenof row and col is 9
        N=9 
        #take three hashsets to check three conditions:
        #for row 
        hr=[set() for _ in range(N)]
        #for col
        hc=[set() for _ in range(N)]
        #for boxes
        hb=[set() for _ in range(N)]
        #iterate through each cell and check all three conditions
        for r in range(N):
            for c in range(N):
                #check if cell is not empty
                if board[r][c]!='.':
                    #check for row
                    if board[r][c] in hr[r]:
                        return False
                    else:
                        hr[r].add(board[r][c])
                    #check for col
                    if board[r][c] in hc[c]:
                        return False
                    else:
                        hc[c].add(board[r][c])
                    #check for box
                    val=((r//3)*3+c//3)
                    if board[r][c] in hb[val]:
                        return False
                    else:
                        hb[val].add(board[r][c])
        return True
                    
        
