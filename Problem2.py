'''
Time Complexity: O(m*n)
Space Complexity: O(max(m,n))
Run on Leetcode: YES
'''
class Solution:
    def isValidSudoku(self, board: list[list[str]]) -> bool:
        #checking rows and columns:
        for i in range(9):
            rowCheck = set()
            colCheck = set()
            for j in range(9):
                # row check
                if board[i][j] != ".":
                    if board[i][j] in rowCheck:
                        return False
                    rowCheck.add(board[i][j])
                
                # col Check
                if board[j][i] != ".":
                    if board[j][i] in colCheck:
                        return False
                    colCheck.add(board[j][i])
        # checking blocks
        for i in range(0,9,3):
            for j in range(0,9,3):
                blockCheck = set()
                for k in range(i,i + 3):
                    for l in range(j,j + 3):
                        if board[k][l] != ".":
                            if board[k][l] in blockCheck:
                                return False
                            blockCheck.add(board[k][l])
                            
        return True