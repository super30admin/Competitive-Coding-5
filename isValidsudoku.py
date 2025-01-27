class Solution:
    # TC : O(1)
    # SC : O(1)
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if board is None:
            return False
        # row - wise iteration
        for i in range(9):
            row_set = set()
            for j in range(9):
                item = board[i][j]
                if item in row_set:
                    return False
                elif item != '.':
                    row_set.add(item)
        
        # col-wise iteration
        for i in range(9):
            col_set = set()
            for j in range(9):
                item = board[j][i]
                if item in col_set:
                    return False
                elif item != '.':
                    col_set.add(item)

        # grid -wise iteration
        grid_start_pts = [(0,0),(0,3),(0,6),(3,0),(3,3),(3,6),(6,0),(6,3),(6,6)]
        for x,y in grid_start_pts:
            grid_set = set()
            for i in range(x,x+3):
                for j in range(y,y+3): 
                    item = board[i][j]
                    if item in grid_set:
                        return False
                    elif item != '.':
                        grid_set.add(item)
        return True
        