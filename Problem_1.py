class Solution:
    """
    TC - O(81)
    SC - O(81)
    """
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if not board or len(board) != 9 or len(board[0]) != 9:
            return False
        tg = set()
        for row in range(9):
            for col in range(9):
                val = board[row][col]
                if val != ".":
                    box_loc = (row // 3) * 3 + (col // 3)
                    if (str(row)+'r'+val in tg) or (str(col)+'c'+val in tg) or (str(box_loc)+'b'+val in tg):
                        return False
                    tg.add(str(row)+'r'+val)
                    tg.add(str(col)+'c'+val)
                    tg.add(str(box_loc)+'b'+val)
        return True