# Space complexity - o(m*n)
# Time Complexity - o(m*n)

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        m, n = len(board), len(board[0])
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]

       
        for i in range(m):
            for j in range(n):
                val = board[i][j]
                if val == '.':
                    continue
                if val in rows[i]:
                    return False
                else:
                    rows[i].add(val)

                if val in cols[j]:
                    return False
                else:
                    cols[j].add(val)

                box_idx = (i//3)*3 +(j//3)
                if val in boxes[box_idx]:
                    return False
                else:
                    boxes[box_idx].add(val)
 
        return True


                

            

        




        