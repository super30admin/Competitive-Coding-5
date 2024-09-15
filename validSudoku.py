# Leetcode 36. Valid Sudoku

# Time Complexity :  O(1) 

# Space Complexity : O(1)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Use hashsets for every row, col and boxes for every element on board. Add a cell value to the
# respective hashsets for row,col and box if the they are already present return false. If all the elements
# are added without any repeats in any of the hashset return True

# Your code here along with comments explaining your approach

class Solution:
    def isValidSudoku(self, board):
        # hashsets to store values of every row, col and box
        rows = [set() for i in range(9)]
        columns = [set() for i in range(9)]
        boxes = [set() for i in range(9)]

        for row_index in range(9):
            for col_index in range(9):
                num = board[row_index][col_index]
                if num != '.':
                    # Box for the particular row n col values on the board
                    box_index = (row_index // 3 ) * 3 + col_index // 3
                    # If value already present in the row return false else add it
                    if num not in rows[row_index] :
                        rows[row_index].add(num)
                    else:
                        return False
                    # If value already present in the row return false else add it
                    if num not in columns[col_index] :
                        columns[col_index].add(num)
                    else:
                        return False
                    # If value already present in the row return false else add it
                    if num not in boxes[box_index] :
                        boxes[box_index].add(num)
                    else:
                        return False
        # If no values are repeated in row or col or box return true
        return True