"""
Use 3 sets to track digits in each row, column, and box
While traversing, check if value already exists in corresponding set
If it is, return False; else, add to set and continue
"""
"""
Time Complexity:
O(1) – Fixed 9x9 board constant time
Space Complexity:
O(1) – Constant size sets for rows, cols, boxes
"""

from typing import List

class validSudoku:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]

        for r in range(9):
            for c in range(9):
                val = board[r][c]
                if val == '.':
                    continue
                if val in rows[r] or val in cols[c] or val in boxes[(r//3)*3 + c//3]:
                    return False
                rows[r].add(val)
                cols[c].add(val)
                boxes[(r//3)*3 + c//3].add(val)

        return True

if __name__ == "__main__":
    obj = validSudoku()
    board = [
        ["5","3",".",".","7",".",".",".","."],
        ["6",".",".","1","9","5",".",".","."],
        [".","9","8",".",".",".",".","6","."],
        ["8",".",".",".","6",".",".",".","3"],
        ["4",".",".","8",".","3",".",".","1"],
        ["7",".",".",".","2",".",".",".","6"],
        [".","6",".",".",".",".","2","8","."],
        [".",".",".","4","1","9",".",".","5"],
        [".",".",".",".","8",".",".","7","9"]
    ]
    print(obj.isValidSudoku(board))
