# TC: O(1), O(81) = rows(9) * col(9)=81
# SC: O(1), O(243) = rows(81)+col(81)+boxes(81)

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        n = 9
        rows = [set() for r in range(0,n)]
        cols = [set() for c in range(0,n)]
        boxes = [set() for b in range(0,n)] #total 9 boxes

        for i in range (0,n):
            for j in range (0,n):
                value = board[i][j]
                box_index = (j//3) + (i//3)*3
                if value == '.':
                    continue
                if (value in rows[i] or value in cols[j] or value in boxes[box_index]):
                    return False
                
                rows[i].add(value)
                cols[j].add(value)
                boxes[box_index].add(value)

        return True
                