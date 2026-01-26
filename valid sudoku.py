class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row=[]
        for i in range(9):
            row.append(set())
        column=[]
        for i in range(9):
            column.append(set())
        box=[]
        for i in range(9):
            box.append(set())
        
        for r in range(9):
            for c in range(9):
                val=board[r][c]
                if val=='.':
                    continue

                box_index=(r//3)*3+(c//3)

                if (val in row[r] or val in column[c] or val in box[box_index]):
                    return False
                row[r].add(val)
                column[c].add(val)
                box[box_index].add(val)
        return True