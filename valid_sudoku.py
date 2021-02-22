#O(1) TIME AND O(1) SPACE
class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        rows = {i:set() for i in range(9)}
        cols = {i:set() for i in range(9)}

        row = 0
        col = 0
        # current_row = 0
        # current_col = 0
        box = 1
        while row < len(board) and col < len(board[0]):
            # print(box)
            box += 1
            sub_box = set()
            for i in range(row,row+3):
                for j in range(col,col + 3):
                    num = board[i][j]
                    if num == ".":
                        continue
                    if num in rows[i] or num in cols[j] or num in sub_box:
                        return False
                    rows[i].add(num)
                    cols[j].add(num)
                    sub_box.add(num)
            col += 3
            if col % 9 == 0:
                row += 3
                col %= 9
        return True

