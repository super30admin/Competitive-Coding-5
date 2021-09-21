# Did this code successfully run on Leetcode : YES

# TC: O(N)
# SC: O(N)


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        return self.check_rows(board) and self.check_cols(board) and self.check_grids(board)
        
    def check_rows(self, board):
        for i in range(9):
            ele = set()
            for num in board[i]:
                if num == '.':
                    continue
                x = int(num)
                if x in ele:
                    return False
                ele.add(x)
        return True
    
    def check_cols(self, board):
        for i in range(9):
            ele = set()
            for num in [item[i] for item in board]:
                if num == '.':
                    continue
                x = int(num)
                if x in ele:
                    return False
                ele.add(x)
        return True
    
    def check_grids(self, board):
        for i in range(3):
            for j in range(3):
                subgrid = [item[3*i:3*(i+1)] for item in board[3*j:3*(j+1)]]
                ele = set()
                for x in range(3):
                    for y in range(3):
                        if subgrid[x][y] == '.':
                            continue
                        n = int(subgrid[x][y])
                        if n in ele:
                            return False
                        ele.add(n)
        return True