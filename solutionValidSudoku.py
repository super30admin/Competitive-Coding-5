Time complexity : size of chess board
Space complexity ;size of chess board
Passed all cases on LC : yes
def isValidSudoku(self, board: List[List[str]]) -> bool:
        N = 9 

        rows = [[] for _ in range(N)]
        cols = [[] for _ in range(N)]
        boxes = [[ [] for _ in range(3)] for _ in range(3)]


        for r in range(N):
            for c in range(N):
                val = board[r][c]

                # check if the position is filled with numeral or empty 
                if val =='.':
                    continue

                idx_i = (r//3); idx_j =c//3 
                # check the row
                if val in rows[r] or val in cols[c] or val in boxes[idx_i][idx_j]:
                    return False 
                rows[r].append(val)

                cols[c].append(val)
                
                boxes[idx_i][idx_j].append(val)
        return True 
