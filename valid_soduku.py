'''
TC = O(1)  as it is 9x9 board elements that has to be processed are only 81
SC = O(1)  fixed-size structures (9 rows, 9 cols, 9 boxes) regardless of input.
Approach : using Hash set 
'''


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row = [set() for _  in range(9)]
        col = [set() for _ in range(9)]
        boxes = [set()for _ in range(9)]

        for r in range(9):
            for c in range(9):
                val = board[r][c]
                if val == '.':
                    continue               
                if val in row[r]:
                    return False
                row[r].add(val)
                if val in col[c]:
                    return False
                col[c].add(val)
                box_indx = (r//3)*3+(c//3)
                if val in boxes[box_indx]:
                    return False
                boxes[box_indx].add(val)
        return True



        