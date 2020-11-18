#Usiing simplee iterative approach to check in 4 directions if sudoku element is valid or not
#Time Complexity: O(n^2)
#Space Complexity: O(n)
from collections import defaultdict
def isValidSudoku(board):
    row = len(board)
    col = len(board[0])
    rowDict = defaultdict(list)
    for i in range(9):
        for j in range(9):
            if board[i][j]!="." and len(rowDict[board[i][j]])==0:
                rowDict[board[i][j]].append([i])
                rowDict[board[i][j]].append([j])
            elif board[i][j]!="." and len(rowDict[board[i][j]])>0:
                lis = rowDict[board[i][j]][0]
                lis2 = rowDict[board[i][j]][1]
                lis.append(i)
                lis2.append(j)
    for elem in rowDict:
        lis1 = rowDict[board[i][j]][0]
        lis2 = rowDict[board[i][j]][1]
        if (len(list(set(lis1))) == len(list(set(lis2)))):
            return True
        else:
            return False



board = [["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]

fed = isValidSudoku(board)
print(fed)

