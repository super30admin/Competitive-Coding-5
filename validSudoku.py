# Time Complexity : O(m*n), where m is the number of rows and n is the number of columns
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach:
# 1. Create three dictionaries to keep track of the numbers seen in each row, column, and square.
# 2. Iterate through each cell in the board.
# 3. For each cell, check if the number is already in the corresponding row, column, or square.
# 4. If it is, return False.
# 5. If not, add the number to the corresponding row, column, and square.
# 6. If we finish iterating through the board without finding any duplicates, return True.

from collections import defaultdict
class Solution:
    def isValidSudoku(self, board) -> bool:
        # Get the dimensions of the board
        m, n = len(board), len(board[0])
        # Create dictionaries to keep track of the numbers seen in each row, column, and 3*3 square
        row = defaultdict(set)
        col = defaultdict(set)
        sq = defaultdict(set)

        # Iterate through each cell in the board
        for i in range(m):
            for j in range(n):
                # If the cell is not empty
                if board[i][j].isdigit():
                    # Convert the cell value to an integer
                    val = int(board[i][j])
                    # Check if the number is already in the corresponding row, column, or square
                    if val in row[i] or val in col[j] or val in sq[(i//3, j//3)]:
                        # If it is, return False
                        return False
                    # If not, add the number to the corresponding row, column, and square to mark it as seen
                    row[i].add(val)
                    col[j].add(val)
                    sq[(i//3, j//3)].add(val)
        # If we finish iterating through the board without finding any duplicates, return True
        return True