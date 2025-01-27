class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # Use sets to track nums in rows, cols and boxes
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]
        # Iterate over the board
        for r in range(9):
            for c in range(9):
                num = board[r][c]
                if num == ".":
                    continue  # Skip empty spaces
                # Check for duplicates
                boxIdx = (r // 3) * 3 + (c // 3)
                if num in rows[r] or num in cols[c] or num in boxes[boxIdx]:
                    return False
                rows[r].add(num)
                cols[c].add(num)
                boxes[boxIdx].add(num)
        return True
        # T: O(1), S: O(1)
