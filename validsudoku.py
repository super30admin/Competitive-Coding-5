#Time Complexity: O(mn)
#Space Complexity: O(mn)
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        dictRow = {}
        dictCol = {}
        dictGrid = {}
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == '.':
                    continue
                if i not in dictRow:
                    dictRow[i] = set()
                if j not in dictCol:
                    dictCol[j] = set()
                    
                if (i//3,j//3) not in dictGrid:
                    dictGrid[(i//3,j//3)] = set()
                  
                
                if board[i][j] in dictRow[i] or board[i][j] in dictCol[j] or board[i][j] in dictGrid[(i//3,j//3)]:
                    return False
                
                dictRow[i].add(board[i][j])
                dictCol[j].add(board[i][j])
                dictGrid[(i//3,j//3)].add(board[i][j])
                
        return True