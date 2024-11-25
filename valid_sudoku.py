"""Explanation:
Use hash sets to track seen numbers for rows, columns, and sub-boxes in a single iteration.
Use a unique identifier for each sub-box (e.g., (row // 3, col // 3)).
Iterate through the board once, adding each number to its respective set. If a number is found twice in any set, the board is invalid.
# Time Complexity: O(9^2) = O(81), as we traverse the board once
# Space Complexity: O(3 * 9^2) = O(81) for storing hash sets
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No
"""

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # Hash sets to track numbers in rows, columns, and boxes
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]

        for row in range(9):
            for col in range(9):
                num = board[row][col]
                if num == '.':
                    continue  # Skip empty cells
                
                # Calculate box index
                box_index = (row // 3) * 3 + (col // 3)
                
                # Check for duplicates
                if num in rows[row] or num in cols[col] or num in boxes[box_index]:
                    return False
                
                # Add the number to the respective sets
                rows[row].add(num)
                cols[col].add(num)
                boxes[box_index].add(num)
        
        return True
