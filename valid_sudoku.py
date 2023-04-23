# Time Complexity: O(n^2) where n is the length/breadth of the board
# Space Complexity: O(n^2) because of the hashsets
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
We use hashsets to solve this problem. We iterate through the board and check if the value is already 
present in the row, col and box sets. If it is, we return false, if not we add it to the relevant sets.
"""

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        if board == None or len(board) == 0: return False

        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]

        for r in range(9):
            for c in range(9):
                val = board[r][c]

                if val == '.': continue

                if val in rows[r]: return False
                rows[r].add(val)

                if val in cols[c]: return False
                cols[c].add(val)

                index = (r//3) * 3 + c // 3
                if val in boxes[index]: return False
                boxes[index].add(val)

        return True