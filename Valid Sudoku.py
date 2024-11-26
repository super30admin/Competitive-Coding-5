# TC : O(81) -- O(MXN)
# SC : O(81) -- O(MXN)
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        grid_number = lambda r,c: 3*(r//3) + (c//3)
        grid = collections.defaultdict(set)
        col = collections.defaultdict(set)
        row = collections.defaultdict(set)
        
        
        for r in range(9):
            for c, val in enumerate(board[r]):
                if val=='.':
                    continue
                box_index = grid_number(r,c)
                if val in grid[box_index] or val in row[r] or val in col[c] :
                    return False
                
                row[r].add(val)
                col[c].add(val)
                grid[box_index].add(val)
        return True