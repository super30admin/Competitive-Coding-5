#Time complexity:O(1) since we know the size of the matrix, 9x9 = 81 
#Space complexity:O(1) since we know the size of the matrix, 9x9 = 81 
#Approach: have a hashset, and check row wise, column wise, block size by checking them in the hashset


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if board == None or len(board) != 9 or len(board[0]) != 9:
            return False
        #row check
        for i in range(0,9):
            hashset = set()
            for j in range(0,9):
                if board[i][j] != '.':
                    if board[i][j] in hashset:
                        return False
                    else:
                        hashset.add(board[i][j])
        
        #column check
        for j in range(0,9):
            hashset = set()
            for i in range(0,9):
                if board[i][j] != '.':
                    if board[i][j] in hashset:
                        return False
                    else:
                        hashset.add(board[i][j])
        
        #block check
        for block in range(0,9):
            hashset = set()
            for i in range(block//3*3, block//3*3+3):
                for j in range(block%3*3, block%3*3+3):
                    if board[i][j] != '.':
                        if board[i][j] in hashset:
                            return False
                        else:
                            hashset.add(board[i][j])
        return True
            
        