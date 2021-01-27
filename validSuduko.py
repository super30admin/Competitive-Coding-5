class Solution:
    '''
    Time and Space Complexity: O(1), O(1)
    '''
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i in range(0,9):
            x = set()
            for j in range(0,9):
                if(board[i][j]=="."):
                    continue
                if(board[i][j] in x):
                    return False
                else:
                    x.add(board[i][j])
            
            x = set()
            for j in range(0,9):
                if(board[j][i]=="."):
                    continue
                if(board[j][i] in x):
                    return False
                else:
                    x.add(board[j][i])
        
            x = set()
            k = (i//3)*3
            j = (i%3)*3
            for r in range(k,k+3):
                for c in range(j,j+3):
                    if(board[r][c]=="."):
                        continue
                    if(board[r][c] in x):
                        return False
                    else:
                        x.add(board[r][c])
        return True
