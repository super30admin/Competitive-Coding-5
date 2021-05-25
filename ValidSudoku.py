# TC: O(M x N) since we are traversing all the elements in the row and column. 
# SC: O(1) since we are just using a constant space of length 9 for the boolean array.

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # print(len(board[0]))
        if not board or len(board) != 9 or len(board[0]) != 9:
            return False
        
        for i in range(len(board)):
            boolean = [False]* 9
            for j in range(len(board[0])):
                if board[i][j] != '.':
                    if boolean[int(board[i][j]) - 1]:
                        # print(boolean)
                        return False
                    boolean[int(board[i][j]) - 1] = True
        
        for j in range(len(board[0])):
            boolean = [False]*9
            for i in range(len(board)):
                if board[i][j] != '.':
                    if boolean[int(board[i][j]) - 1]:
                        return False
                    boolean[int(board[i][j]) - 1] = True
        
        for block in range(len(board)):
            boolean = [False]*9
            rows = (block // 3) * 3
            cols = (block % 3) * 3
            for i in range(rows, rows + 3):
                for j in range(cols, cols + 3):
                    if board[i][j] != '.':
                        if boolean[int(board[i][j]) - 1]:
                            return False
                        boolean[int(board[i][j]) - 1] = True
        return True
