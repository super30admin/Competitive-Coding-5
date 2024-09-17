#valid sudoku
#time complexity: O(n^2) where N is not fixed like it is for 9 
#space complexoty: O(n*2)

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        N = 9
        row = [set() for _ in range(N)]
        col = [set() for _ in range(N)]
        box = [set() for _ in range(N)]
        
        for r in range(N):
            for c in range(N):
                val = board[r][c]
                if val ==".":
                    continue
                if val in row[r]:
                    return False
                row[r].add(val)
                if val in col[c]:
                    return False
                col[c].add(val)
                idx = (r//3)*3+c//3
                if val in box[idx]:
                    return False
                box[idx].add(val)
        return True
        