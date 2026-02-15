# Time: O(1) as the elements are already given as 9
# Space: O(1) as we have an array of fixed size that is 9

# First we loop through all the rows and check if the row is valid
# then we do the same loopin on the cols
# then we loop on the squares and check if the square is valid
# At each point we check if something is not valid so that we terminate early and don't go forward
# If we don't return False then at the end we return True.

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i in range(9):
            rwCheck = self.checkRow(i,board)
            if not rwCheck: return False
        for j in range(9):
            clCheck = self.checkCol(j,board)
            if not clCheck: return False

        for i in range(0,9,3):
            for j in range(0,9,3):
                values = [False] * 9
                sq = self.calcSq(i,j,values,board)
                if not sq:
                    return False
        return True


    def calcSq(self,r,c,values,board):
        for m in range(r,r+3):
            for n in range(c,c+3):
                if board[m][n] != '.':
                    num = int(board[m][n])
                    if values[num-1]:
                        return False
                    else:
                        values[num-1] = True
        return True

    def checkRow(self,r,board):
        values = [False] * 9
        for j in range(9):
            if board[r][j] != '.':
                num = int(board[r][j])
                if values[num-1]:
                    return False
                else:
                    values[num-1] = True
        return True

    def checkCol(self,c,board):
        values = [False] * 9
        for i in range(9):
            if board[i][c] != '.':
                num = int(board[i][c])
                if values[num-1]:
                    return False
                else:
                    values[num-1] = True
        return True
    

# Time: O(1)
# Space: O(1)

# SINGLE PASS APPROACH

# We have different sets initialised for each row column and the square
# while looping through the whole matrix we check if it is '.' then we skip that iteration
# If not then we calculate the sqIdx with formula and check whether the number is present in the row, col or sq if yes then return False
# Else at the end return True
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        sq = [set() for _ in range(9)]

        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    continue
                num = int(board[i][j])

                sqIdx = (i // 3) * 3 + (j // 3)

                if num in rows[i] or num in cols[j] or num in sq[sqIdx]:
                    return False
                rows[i].add(num)
                cols[j].add(num)
                sq[sqIdx].add(num)

        return True