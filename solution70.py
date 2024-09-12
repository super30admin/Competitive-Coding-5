#Time Complexity:O(3mn)
#Space Complexity:O(n)
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if len(board)==0 or len(board)<9 or len(board[0])<9:        #if the board is not 9x9 return false
            return False
        for i in range(9):                                          #for each row create a boolean arrayof size 9 and initialize it to be false
            b=[False for i in range(9)]
            for j in range(9):
                if board[i][j]!=".":                                #if a number exists, check if the value of number in boolean array is true, and return false
                    if b[int(board[i][j])-1]==True:                 #change the boolean array value at the index of number to true
                        return False
                    b[int(board[i][j])-1]=True
        for j in range(9):                                          #repeat the row check for column too
            b=[False for i in range(9)]
            for i in range(9):
                if board[i][j]!=".":
                    if b[int(board[i][j])-1]==True:
                        return False
                    b[int(board[i][j])-1]=True
        for block in range(9):                                      #repeat the check for every block
            b=[False for i in range(9)]
            for i in range(block//3*3,block//3*3+3):
                for j in range(block%3*3,block%3*3+3):
                    print(i,j)
                    if board[i][j]!=".":
                        if b[int(board[i][j])-1]==True:
                            return False
                        b[int(board[i][j])-1]=True
        return True                                                 #return true if the board is processed fully