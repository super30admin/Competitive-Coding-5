# Time Complexity :
# O(N^2)  - Size of the Matrix

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#We do a row test, column test and grid test
#In row test, we go through the all the rows and check if all elements(not "." elements) are unique. If they aren't we return False
#We do the same in column test
#For thew grid test, we use the same logic of going through each grid, and each element in each grid and checking if they are all unique. We move been grids using 4 loop of  Sqrt(N) each

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        values = {}

        #IS valid row 
        for i in range(0,len(board)):
            for j in range(0,len(board[0])):
                if board[i][j] == '.':
                    continue
                else:
                    if board[i][j] in values :
                        return False
                    else :
                        values[board[i][j]] = 0

            values = {}

        #Is valid column 
        for j in range(0,len(board)):
            for i in range(0,len(board[0])):
                if board[i][j] == '.':
                    continue
                else:
                    if board[i][j] in values :
                        return False
                    else :
                        values[board[i][j]] = 0
            values = {}

        #is valid grid
        for i in range(0,3):
            for j in range(0,3):
                for k in range(i*3,(i*3)+3):
                    for l in range(j*3,(j*3)+3):
                        if board[k][l] == '.':
                            continue
                        else:
                            if board[k][l] in values :
                                return False
                            else :
                                values[board[k][l]] = 0
                values = {}
        return True
