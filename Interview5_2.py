# Valid Sudoku
# Time complexity -> O(n) However since we know the matrix size is always 9*9 and so it will always by 81 cells it is O1
# as we iterate over each element only once
# Space complexity -> O1 -> we do created 2 arrays and a matrix but those are always of constant sizes


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rangeSet = {"1","2","3","4","5","6","7","8","9"}

        # Use range(9), not "range in(9)   "
        rowArr = [rangeSet.copy() for _ in range(9)]
        columnArr = [rangeSet.copy() for _ in range(9)]

        # For the 3x3 matrix
        innerMatrix = [[rangeSet.copy() for _ in range(3)] for _ in range(3)]
        for i in range (0,9):
            for j in range(0,9):
                val = board[i][j]
                if val == ".":
                    continue
                #check row
                if val not in rowArr[i]:
                    return False
                rowArr[i].remove(val)

                # check column
                if val not in columnArr[j]:
                    return False
                columnArr[j].remove(val)

                #check inner matrix 
                ir = i//3
                ic = j//3
                if val not in innerMatrix[ir][ic]:
                    return False
                innerMatrix[ir][ic].remove(val)

        return True
                
