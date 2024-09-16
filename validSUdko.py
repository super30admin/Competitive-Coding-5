#Time: O(n^2)
#Space: O(n)
#Program ran on leetcode successfully

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if board is None or len(board) != 9 or len(board[0]) != 9:
            return False
        
        #checking rows
        for i in range(9):
            b = [False] * 9
            for j in range(9):
                if board[i][j] != '.':
                    if b[int(board[i][j] - '1')]:
                        return False
                    b[int(board[i][j] - '1')] = True
        
        #checking columns
        for j in range(9):
            b = [False] * 9
            for i in range(9):
                if board[i][j] != '.':
                    if b[int(board[i][j] - '1')]:
                        return False
                    b[int(board[i][j] - '1')] = True
        

        for block in range(9):
            b = [False] * 9
            for i in range(block/3*3, block/3*3 + 3):
                for j in range(block%3*3, block%3*3 + 3):
                    if board[i][j] != '.':
                        if b[int(board[i][j] - '1')]:
                            return False
                        b[int(board[i][j] - '1')] = True
        
        return True

        
