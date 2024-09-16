class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:

        if board is None or len(board)==0:
            return True

        row = [{} for i in range(9)]
        col = [{} for i in range(9)]

        box = [{} for i in range(9)]

        for i in range(9):
            for j in range(9):

                num = board[i][j]
                if num != '.':
                    num = int(num)
                    box_index = (i//3)*3+j//3
                    row[i][num] = row[i].get(num,0)+1
                    col[j][num] = col[j].get(num,0)+1
                    box[box_index][num] = box[box_index].get(num,0)+1

                    if row[i][num] > 1 or col[j][num] > 1 or box[box_index][num] >1:
                        return False

        return True
