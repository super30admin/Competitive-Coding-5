# Time Complexity: O(n^2) - O(81)
# Space Complexity: O(n^2)

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        m = len(board)
        n = len(board[0])
        
        for i in range(m):
            temp1 = set()
            temp2 = set()
            for j in range(n):
                
                if board[i][j] != '.':
                    
                    if (int(board[i][j]) > 0 and int(board[i][j]) <= 9) == False: return False
                    if int(board[i][j]) not in temp1:
                        temp1.add(int(board[i][j]))
                    else:
                        return False
                    if len(temp1) > 9:return False
                
                
                if j == 3 and i == 0:
                    print(j,i)
                
                if board[j][i] != '.':
                    if (int(board[j][i]) > 0 and int(board[j][i]) <= 9) == False: return False
                    if int(board[j][i]) not in temp2:
                        temp2.add(int(board[j][i]))
                    else:
                        return False
                    if len(temp2) > 9: return False
                
                if i % 3 == 0 and j % 3 == 0:
                    temp3 = set()
                    for x in range(i,i+3):
                        for y in range(j,j+3):
                            if board[x][y] != '.':
                                if (int(board[x][y]) > 0 and int(board[x][y]) <= 9) == False: return False
                                if board[x][y] not in temp3:
                                    temp3.add(board[x][y])
                                else:
                                    return False
                    if len(temp3) > 9: return False
        
        return True



# Alternate approach (similar)
#Time complexity: O(n^2) -> O(81)
#Space complexity: O(n^2)
class Solution:
    def isValidSudoku(self, board) -> bool:
        dictRow={}
        dictCol={}
        dictgrid={}
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j]==".":
                    continue
                if i  not in dictRow:
                    dictRow[i]=set()
                if j  not in dictCol:
                    dictCol[j]=set()
                if (i//3,j//3) not in dictgrid:
                    dictgrid[(i//3,j//3)]=set()
                if board[i][j] in dictRow[i] or board[i][j] in dictCol[j] or board[i][j] in dictgrid[(i//3,j//3)]:
                    return False
                dictRow[i].add(board[i][j])
                dictCol[j].add(board[i][j])
                dictgrid[(i//3,j//3)].add(board[i][j])
        return True