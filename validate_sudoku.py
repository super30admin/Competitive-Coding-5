# O(1) TIME AND O(1) SPACE
class Solution:
    def isValidSudoku(self, board):
        rows = [{} for _ in range(9)]
        cols = [{} for _ in range(9)]
        boxes = [{} for _ in range(9)]
        
        for i in range(9):
            for j in range(9):
                current = board[i][j]
                if current == ".":
                    continue
                
                current = int(current)
                boxidx = (i // 3) * 3 + j // 3
                if current in rows[i] or current in cols[j] or current in boxes[boxidx]  :
                    return False
                rows[i][current] = True
                cols[j][current] = True
                boxes[boxidx][current] = True
        return True