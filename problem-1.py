class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [set() for i in range(len(board))]
        cols = [set() for i in range(len(board))]
        boxes = [set() for i in range(len(board))]
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                val = board[i][j]
                if val==".":
                    continue
                
                if val in rows[i] or val in cols[j] or val in boxes[(i//3)*3+j//3]:
                    return False
                
                rows[i].add(val)
                cols[j].add(val)
                boxes[(i//3)*3+j//3].add(val)
                
        return True
                
        